import { lazy, SyntheticEvent, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import CouponModel from "../../../Models/CouponModel";
import { authStore } from "../../../Redux/AuthState";
import companiesService from "../../../Services/CompaniesService";
import notificationService from "../../../Services/NotificationService";
import CompanyCouponCard from "../../SharedArea/CompanyCouponCard/CompanyCouponCard";
import "./CompanyCoupons.css";

function CompanyCoupons(): JSX.Element {

    //Class Variables:
    const [originalCoupons, setOriginalCoupons] = useState<CouponModel[]>([]);
    const [coupons, setCoupons] = useState<CouponModel[]>([]);

    //----------------------------------
    //Show Company Coupons Function:
    //----------------------------------
    useEffect(() => {
        const companyId = authStore.getState().user.id;

        companiesService.fetchCompanyCoupons()
            .then(coupons => {
                setOriginalCoupons([...coupons])
                setCoupons([...coupons])
            })
            .catch(err => notificationService.error(err));
    }, []);


    //----------------------------------
    //Filter Coupons By Price Function:
    //----------------------------------
    function filterByPrice(args: SyntheticEvent) { // SyntheticEvent  - wrapper for event arguments
        const input = args.target as HTMLInputElement;
        const maxPrice = +input.value;
        if (input.value === "") {
            setCoupons(originalCoupons);
        }
        else {
            const filteredCoupons = originalCoupons.filter(c => c.price <= maxPrice);
            setCoupons(filteredCoupons);
        }
    }


    //----------------------------------
    //Filter Coupons By ID Function:
    //----------------------------------

    function filterById(args: SyntheticEvent) { // SyntheticEvent - wrapper for event arguments
        const input = args.target as HTMLInputElement;
        const couponId = +input.value;
        if (input.value === "") {
            setCoupons(originalCoupons);
        }
        else {
            const filteredCoupons = originalCoupons.filter(c => c.id === couponId);
            setCoupons(filteredCoupons);
        }

    }


    //----------------------------------
    //Filter Coupons By Category Function:
    //----------------------------------
    function filterByCategory(args: SyntheticEvent) {
        const select = args.target as HTMLSelectElement;
        const category = select.value;
        const filteredCoupons = originalCoupons.filter(c => c.category === category);
        setCoupons(filteredCoupons);
    }

    const navigate = useNavigate();

    const navigateCreateCoupon = () => {
        navigate("/companies/create-coupon");
    };



    //----------------------------------
    // Company Coupons Page:
    //----------------------------------
    return (
        <div className="CompanyCoupons">
            <button onClick={navigateCreateCoupon} className="create">Create New Coupon</button>

            <span className="header">Filtering Options</span>
            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>

            <label className="couponId">Coupon ID:</label>
            <input type="number" onChange={filterById} />
            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>

            <label className="input">Max Coupon Price:</label>
            <input type="number" onChange={filterByPrice} />

            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>

            <label className="dropDown">Product Category:</label>
            <select defaultValue="" onChange={filterByCategory}>


                <option disabled value="">Select Category</option>
                <option>FOOD</option>
                <option>BEVERAGE</option>
                <option>JUNKFOOD</option>
                <option>SPORTS</option>
                <option>TRAVEL</option>
                <option>ELECTRONICS</option>
                <option>RESTAURANTS</option>
                <option>VACATION</option>
                <option>CLOTHING</option>
                <option>SHOES</option>
                <option>OTHERS</option>

            </select>

            <hr />
            <span>{coupons.map(c => <CompanyCouponCard key={c.id} coupon={c} />)}</span>

        </div>
    );
}

export default CompanyCoupons;


