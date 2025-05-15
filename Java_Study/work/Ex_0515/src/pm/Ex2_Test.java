package pm;
// 제네릭타입
public class Ex2_Test<T> {
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
