import CouponModel from "../../../Models/CouponModel";
import "./CouponCard.css";

interface CouponCardProps {
    coupon: CouponModel;	
    buy?: (couponId: number) => void;
}


function CouponCard(props: CouponCardProps): JSX.Element {
    
    const style = {
        backgroundImage: 'url(${props.coupon.imageUrl})'
    };

    return (
        <div className="CouponCard">
            <span className="title">{props.coupon.title}</span> <br />
            <span className="description"> {props.coupon.description}</span> <br />
            <span className="category">Category: {props.coupon.category}</span> <br />
            <span className="startDate">Start: 🗓 {props.coupon.startDate} </span> <br />
            <span className="endDate">End: ⏰ {props.coupon.endDate} </span> <br />
            <span className="amount">Amount: {props.coupon.amount}</span> <br />
            <span className="price">Price: ＄{props.coupon.price} </span> <br />
            <img src={props.coupon.image} />
            
            {
                props.buy &&
                <button onClick={() => props.buy(props.coupon.id)} className="button">Add To Cart</button>
            }
            
        </div>
    );
}

export default CouponCard;
