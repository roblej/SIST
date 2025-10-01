import Image from 'next/image';
import styles from './page.module.css';

export default function Home() {
  return (
    <div className={styles.page}>
      <h2>쌍용교육센터</h2>
      <hr />
      <p>포맷팅 테스트입니다. 이 텍스트는 정렬되어야 합니다.</p>
    </div>
  );
}
