import CouponModel from "../../../Models/CouponModel";
import { useNavigate } from "react-router-dom";
import "./CompanyCouponCard.css";
import companiesService from "../../../Services/CompaniesService";
import notificationService from "../../../Services/NotificationService";


interface CouponCardProps {
    coupon: CouponModel;
}




function CompanyCouponCard(props: CouponCardProps): JSX.Element {

    const navigate = useNavigate();
    const navigateForDelete = useNavigate();

    const navigateUpdateCoupon = () => {
        navigate("/companies/update-coupon/" + props.coupon.id);
    };

    const navigateDeleteCoupon = () => {
        try {
            companiesService.deleteCoupon(props.coupon.id);
            notificationService.success("coupon deleted successfully!");
            navigate("/companies/company-coupons");
        }
        catch (err: any) {
            notificationService.error(err)
        }
    };

    return (
        <div className="CompanyCouponCard">
            <span className="title">{props.coupon.title}</span> <br />
            <span className="description">{props.coupon.description}</span> <br />
            <span className="category">Category:{props.coupon.category}</span> <br />
            <span className="coupId">Coupon ID: {props.coupon.id}</span> <br />
            <span className="startDate">Start: 🗓 {props.coupon.startDate}</span> <br />
            <span className="endDate">End: ⏰ {props.coupon.endDate}</span> <br />
            <span className="amount">Amount: {props.coupon.amount}</span> <br />
            <span className="price">Price: ＄{props.coupon.price}</span> <br />
            <img src={props.coupon.image} />

            <button onClick={navigateUpdateCoupon} className="edit">Update</button>
            <button onClick={navigateDeleteCoupon} className="delete">Delete </button>

        </div>
    );
}


export default CompanyCouponCard;
