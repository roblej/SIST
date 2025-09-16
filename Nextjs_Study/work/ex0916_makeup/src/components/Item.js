import styles from "./css/item.module.css";
export default function Item(props){
    const {
        id,
        image_link,
        name,
        description,
        price,
        updated_at,
        category,
        product_type,
        product_link,
    } = props.item;
    
    return (
        <div className={styles.wrap}>
            <div className={styles.disWrap}>
                <img src={image_link} alt={name} className={styles.img_item}/>
                <div className={styles.info_item}>
                    <h2 className={styles.title_item}>{name}</h2>
                    <p className={styles.num_price}>${price}</p>
                <span className={styles.txt_info}>
                    {category ? <span>카테고리: {category}/</span> : ""}
                    {product_type ? <span>제품 타입: {product_type}/</span> : ""}
                    {updated_at ? <span>업데이트: {updated_at}/</span> : ""}
                    {product_link ? <button onClick={()=>window.open(product_link, '_blank')}>구매하기</button> : ""}
                </span>
                </div>
            </div>
        </div>
    );
}