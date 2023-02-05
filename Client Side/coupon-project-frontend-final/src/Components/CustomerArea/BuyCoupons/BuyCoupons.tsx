import { useEffect, useState } from "react";
import CouponModel from "../../../Models/CouponModel";
import { customersReducer } from "../../../Redux/CustomersState";
import customersService from "../../../Services/CustomersService";
import notificationService from "../../../Services/NotificationService";
import CouponCard from "../../SharedArea/CouponCard/CouponCard";

//------------------------------
// Buy Coupons Functions:
//------------------------------
function BuyCoupons(): JSX.Element {
// variables:
    const [coupons, setCoupons] = useState<CouponModel[]>([]);

    useEffect(() => {
        customersService.fetchOtherCoupons()
            .then(coupons => setCoupons(coupons))
            .catch(err => notificationService.error(err));
    }, []);
  
//------------------------------    
    async function buyCoupon(couponId: number) {
    
        try {
            const coupon = await customersService.buyCoupon(couponId);
            notificationService.success(`Coupon has been purchased`);
        }
        catch (err: any) {
            notificationService.error(err);
        }
    }
//------------------------------
// Buy Coupons Web:
//------------------------------
    return (
        <div className="BuyCoupons">
            <h2>Buy Coupons</h2>
            {/* using the coupon card */}
            {coupons.map(c => <CouponCard key={c.id} coupon={c} buy={buyCoupon} />)}
        </div>
    );
}

    export default BuyCoupons;
