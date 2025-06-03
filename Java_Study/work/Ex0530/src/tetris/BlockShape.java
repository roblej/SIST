package tetris;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class BlockShape {
	Point cur_pt = new Point(0, 0);//블럭의 시작점
	int b_style; // 블럭의 모양
	
	int rotation; // 블럭의 각도(0,1,2,3)결국 3차원배열의 있는 2차원
					//배열의 index값이다.
	
	//실제 표현할 도형의 값(4개)
	Point[] b_shape = new Point[4];
	
	//블럭의 그림자간의 y좌표 거리
	int b_shadow_dis;
	
	//그림자 블럭의 색상 투명도 값
	//(0이면 나타나지 않는다.)
	int shadow_alpha = 70;
	
	Color color; // 블럭의 색상
	
	Random rnd = new Random();

	public BlockShape(int b_style, Color c) {
		this.b_style = b_style;//블럭의 모양(0~6)
		this.color = c; //블럭의 색상
		
		//this.rotation = (int)(Math.random()*4);
		this.rotation = rnd.nextInt(4);//지정된 모양의 각도
		
		// b_shape라는 배열에 그리고자 하는
		//4개의 도형 위치값을 저장한다.
		int i=0;
		for(int row=0; row<Shape.SHAPE[b_style][rotation].length; row++) {
			for(int col=0; col<Shape.SHAPE[b_style][rotation][row].length; col++) {
				//값이 1인 것들만 찾아낸다.
				if(Shape.SHAPE[b_style][rotation][row][col] == 1)
					this.b_shape[i++] = new Point(row, col);
			}
		}//for문의 끝
	}//생성자의 끝
	
	//시간에 따라 블럭이 내려가는 기능
	//(다른블럭과 바닥과의 충돌체크)
	public void moveDown(Block[][] b) {
		boolean check = false;// 충돌여부 확인
		
		//충돌체크 반복문
		for(int i=0; i<4; i++) {
			//바로 아래칸이 채워져 있다면 이동할 수 없다.
			if(b[this.b_shape[i].x+1][this.b_shape[i].y].isfilled) {
				//현재 위치에 멈추기 위해 isfilled값을 true로 변경
				b[this.b_shape[i].x][this.b_shape[i].y].isfilled = true;
				check = true;
				break;
			}
		}
		
		//충돌이 되었다면 check변수에 true가 들어가 있고, 그렇지 않다면
		//check변수에는 false를 가지고 있다.
		//블럭이 계속 진행하려면 check변수가 false값을 가져야 한다.
		if(!check) {
			for(int i=0; i<4; i++) {
				//지나온 자리
				b[this.b_shape[i].x][this.b_shape[i].y].isVisible = false;
				
				//그림자 처리 - 기존의 그림자는 없앤다.
				b[this.b_shape[i].x + b_shadow_dis]
				  [this.b_shape[i].y].isVisible = false;
				
				this.b_shape[i].x += 1;
				if(this.b_shape[i].x >= 23)
					this.b_shape[i].x = 23;
			}
			
			getShadowBlock(b);//그림자 거리 체크
			
			//그림자와의 거리를 계산했기 때문에 그림자를 표현
			for(int i=0; i<4; i++) {
				b[b_shape[i].x + b_shadow_dis]
				  [b_shape[i].y].isVisible = true;
				
				b[b_shape[i].x + b_shadow_dis][b_shape[i].y].color =
					new Color(color.getRed(),
							  color.getGreen(),
							  color.getBlue(), shadow_alpha);
				
				//떨어지는 블럭을 보여주기 위해 isVisible값 변경
				b[b_shape[i].x][b_shape[i].y].isVisible = true;
				b[b_shape[i].x][b_shape[i].y].color = color;
			}
			//현재 기준점 증가
			this.cur_pt.x += 1; 
		}else {
			//충돌했을 경우
			// 현재 내려오던 블럭이 하나라도 멈췄다면
			// 블럭을 이루는 4개의 상자 모두가 멈춰야 한다.
			// 그러기 위해서는 isfilled값 변경해야 함!
			for(int i=0; i<4; i++) {
				b[b_shape[i].x][b_shape[i].y].isfilled = true;
				b[b_shape[i].x][b_shape[i].y].color = color;
			}
		}
	}
	
	public void leftKey(Block[][] b) {
		boolean check = false;// 충돌여부 확인
		
		//충돌체크 반복문
		for(int i=0; i<4; i++) {
			//바로 왼쪽칸이 채워져 있다면 이동할 수 없다.
			if(b[this.b_shape[i].x][this.b_shape[i].y-1].isfilled) {
				//현재 위치에 멈추는 동작이 있어서는 안된다.
				// 떨어지는 것은 아래로 계속 떨어지면서 왼쪽으로
				//이동이 가능한지? 여부를 확인하는 것이다.
				
				check = true;
				break;
			}
		}
		
		//충돌이 되었다면 check변수에 true가 들어가 있고, 그렇지 않다면
		//check변수에는 false를 가지고 있다.
		//블럭이 계속 진행하려면 check변수가 false값을 가져야 한다.
		if(!check) {// 현재 내려오던 블럭이 계속 진행중이면...
			for(int i=0; i<4; i++) {
				//지나온 자리
				b[this.b_shape[i].x][this.b_shape[i].y].isVisible = false;
				
				//그림자 처리 - 기존의 그림자는 없앤다.
				b[this.b_shape[i].x + b_shadow_dis]
				  [this.b_shape[i].y].isVisible = false;
				
				//현재 위치 변경(왼쪽으로 1칸 이동)
				this.b_shape[i].y -= 1;
				if(this.b_shape[i].y < 4)
					this.b_shape[i].y = 4;
			}
			
			getShadowBlock(b);//그림자 거리 체크
			
			//그림자와의 거리를 계산했기 때문에 그림자를 표현
			for(int i=0; i<4; i++) {
				b[b_shape[i].x + b_shadow_dis]
				  [b_shape[i].y].isVisible = true;
				
				b[b_shape[i].x + b_shadow_dis][b_shape[i].y].color =
					new Color(color.getRed(),
							  color.getGreen(),
							  color.getBlue(), shadow_alpha);
				
				//떨어지는 블럭을 보여주기 위해 isVisible값 변경
				b[b_shape[i].x][b_shape[i].y].isVisible = true;
				b[b_shape[i].x][b_shape[i].y].color = color;
			}
			//현재 기준점 증가
			this.cur_pt.y -= 1; 
		}
	}
	
	public void rightKey(Block[][] b) {
		boolean check = false;// 충돌여부 확인
		
		//충돌체크 반복문
		for(int i=0; i<4; i++) {
			//바로 왼쪽칸이 채워져 있다면 이동할 수 없다.
			if(b[this.b_shape[i].x][this.b_shape[i].y+1].isfilled) {
				//현재 위치에 멈추는 동작이 있어서는 안된다.
				// 떨어지는 것은 아래로 계속 떨어지면서 왼쪽으로
				//이동이 가능한지? 여부를 확인하는 것이다.
				
				check = true;
				break;
			}
		}
		
		//충돌이 되었다면 check변수에 true가 들어가 있고, 그렇지 않다면
		//check변수에는 false를 가지고 있다.
		//블럭이 계속 진행하려면 check변수가 false값을 가져야 한다.
		if(!check) {// 현재 내려오던 블럭이 계속 진행중이면...
			for(int i=0; i<4; i++) {
				//지나온 자리
				b[this.b_shape[i].x][this.b_shape[i].y].isVisible = false;
				
				//그림자 처리 - 기존의 그림자는 없앤다.
				b[this.b_shape[i].x + b_shadow_dis]
				  [this.b_shape[i].y].isVisible = false;
				
				//현재 위치 변경(왼쪽으로 1칸 이동)
				this.b_shape[i].y += 1;
				if(this.b_shape[i].y > 13)
					this.b_shape[i].y = 13;
			}
			
			getShadowBlock(b);//그림자 거리 체크
			
			//그림자와의 거리를 계산했기 때문에 그림자를 표현
			for(int i=0; i<4; i++) {
				b[b_shape[i].x + b_shadow_dis]
				  [b_shape[i].y].isVisible = true;
				
				b[b_shape[i].x + b_shadow_dis][b_shape[i].y].color =
					new Color(color.getRed(),
							  color.getGreen(),
							  color.getBlue(), shadow_alpha);
				
				//떨어지는 블럭을 보여주기 위해 isVisible값 변경
				b[b_shape[i].x][b_shape[i].y].isVisible = true;
				b[b_shape[i].x][b_shape[i].y].color = color;
			}
			//현재 기준점 증가
			this.cur_pt.y += 1; 
		}
	}
	
	//스페이스 바를 눌렀을 때 한번에 이동하는 기능
	public void fastMove(Block[][] b) {
		//현재 위치의 블럭들을 지우는 반복문
		for(int i=0; i<4; i++) {
			b[b_shape[i].x][b_shape[i].y].isVisible = false;
			
			//그림자의 위치값(거리값)을 b_shape[]에 저장한다.
			b_shape[i].x += b_shadow_dis;
			
			//받은 값이 화면의 바닥을 넘었는지 검사하여 넘었을 경우에만
			//화면의 바닥 값으로 넣어준다.
			if(b_shape[i].x > 23)
				b_shape[i].x = 23;
		}
		
		//블럭을 다시 그린다.
		for(int i=0; i<4; i++) {
			b[b_shape[i].x][b_shape[i].y].isfilled = true;
			b[b_shape[i].x][b_shape[i].y].isVisible = true;
			b[b_shape[i].x][b_shape[i].y].color = color;
		}
	}
	
	// up키를 누를 때마다 블럭을 턴 시키는 기능
	public void rotation(Block[][] b) {
		//각도를 기억하는 배열 값(0,1,2,3)을 1 증가 시킨다.
		//주의해야 할 점은 3을 넘어서는 안된다. 다시 말해서
		// 4이상의 값을 가져서는 안된다.
		rotation = ++rotation%4;
		
		//턴이 된 블럭모양을 담을 배열!
		//(b_shape배열과 같은 배열이 필요함)
		Point[] p = new Point[4];
		
		int idx = 0;// 위의 p배열을 접근하는 인덱스 값!
		
		//턴이 된 모양을 구성할 값은 Shape클래스가 가지고 있으므로
		//거기에서 원하는 모양의 블럭 안에 rotation각도에 해당하는
		// 2차원배열에서 1인 값들만 가져온다.
		for(int row=0; row<Shape.SHAPE[b_style][rotation].length; row++) {
			for(int col=0; col<Shape.SHAPE[b_style][rotation][row].length; col++) {
				if(Shape.SHAPE[b_style][rotation][row][col] == 1)
					p[idx++] = new Point(row, col);
			}
		}
		
		boolean check = false;
		int leftWall = 0;
		int rightWall = 0;
		for(int i=0; i<4; i++) {
			// 게임판(block)에서 현재 블럭이 각도가 변경될 때의 위치가
			//채워져 있는 경우에만 살짝 이동을 하기 위한 비교문
			if(b[p[i].x + cur_pt.x][p[i].y + cur_pt.y].isfilled) {
				check = true;
				
				if(p[i].y+cur_pt.y >= 4 && p[i].y+cur_pt.y<=13) {
					//보여지는 게임화면에서 충돌이 발생한 경우
					break;
				}
				if(p[i].y+cur_pt.y == 15) {
					//오른쪽으로 2칸 나간 경우
					rightWall = 2;
				}else if(p[i].y+cur_pt.y == 14) {
					//오른쪽으로 1칸 나간 경우
					rightWall = 1;
				}else if(p[i].y+cur_pt.y == 3) {
					//왼쪽으로 1칸 나간 경우
					leftWall = 1;
				}else if(p[i].y+cur_pt.y == 2) {
					//왼쪽으로 2칸 나간 경우
					leftWall = 2;
				}
			}
		}
		
		if(!check || leftWall >= 1 || rightWall >= 1) {
			for(int i=0; i<4; i++) {
				//현재 블럭 지우고
				b[b_shape[i].x][b_shape[i].y].isVisible = false;
				
				//현재 그림자 지우기
				b[b_shape[i].x + b_shadow_dis]
				 [b_shape[i].y].isVisible = false;
				
				//턴이 된 모양을 현재 블럭의 모양으로 지정하기 위해
				//배열 p의 값들을 배열 b_shape에 저장한다.
				// b_shape = p; //이렇게 단순하게 변경하면
				// process메서드의 if문에서 b_shape[0].x 등으로 비교문을
				// 구현했는데... 여기서 조건에 만족하지 않는 상황이
				// 발생할 수도 있겠다는 판단에 하나씩 넣어준다.
				b_shape[i].x = p[i].x + cur_pt.x;
				b_shape[i].y = p[i].y + cur_pt.y + leftWall - rightWall;
			}
			
			getShadowBlock(b);
			
			//턴된 블럭과 그림자를 그린다.
			for(int i=0; i<4; i++) {
				b[b_shape[i].x + b_shadow_dis]
				  [b_shape[i].y].isVisible = true;
				
				b[b_shape[i].x + b_shadow_dis][b_shape[i].y].color =
					new Color(color.getRed(),
							  color.getGreen(),
							  color.getBlue(), shadow_alpha);
				
				//떨어지는 블럭을 보여주기 위해 isVisible값 변경
				b[b_shape[i].x][b_shape[i].y].isVisible = true;
				b[b_shape[i].x][b_shape[i].y].color = color;
			}
		}
	}
	
	
	//그림자 모양의 위치를 파악하는 기능
	public void getShadowBlock(Block[][] b) {
		int value = 1;
		bk:while(value < 24) {
			for(int i=0; i<4; i++) {
				
				//블럭의 아래쪽 칸들을 채워졌는지 체크
				if(b_shape[i].x + value >= 24 ||
					b[b_shape[i].x + value][b_shape[i].y].isfilled)
					break bk;
			}
			value++;
		}
		b_shadow_dis = value-1;
	}
}








