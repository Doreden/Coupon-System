import { WindowSharp } from "@mui/icons-material";
import { SyntheticEvent, useEffect, useState } from "react";
import CouponModel from "../../../Models/CouponModel";
import customersService from "../../../Services/CustomersService";
import notificationService from "../../../Services/NotificationService";
import CouponCard from "../../SharedArea/CouponCard/CouponCard";
import "./CustomerCoupons.css";

function CustomerCoupons(): JSX.Element {
    //Class Variables:

    const [originalCoupons, setOriginalCoupons] = useState<CouponModel[]>([]);
    const [coupons, setCoupons] = useState<CouponModel[]>([]);


    //----------------------------------
    //Show Customer Coupons Function:
    //----------------------------------
    useEffect(() => {
        customersService.fetchMyCoupons()
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
    //Filter Coupons By Category Function:
    //----------------------------------
    function filterByCategory(args: SyntheticEvent) {
        const select = args.target as HTMLSelectElement;
        const category = select.value;
        const filteredCoupons = originalCoupons.filter(c => c.category === category);
        setCoupons(filteredCoupons);
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
    // Customer Coupons Page:
    //----------------------------------
    return (
        <div className="CustomerCoupons">
            {/*------------------Filtering Option---------------*/}
            <span className="header">Filtering Options</span>
            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>
            
            {/*------------------Filter By Coupon ID---------------*/}
            <label className="couponId">Coupon ID:</label>
            <input type="number" onChange={filterById} />
            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>
            
            {/*------------------Filter By Coupon Price---------------*/}
            <label className="input">Max Price:</label>
            <input type="number" onChange={filterByPrice} />

            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>

            {/*------------------Filter By Coupon Category---------------*/}
            <label className="dropDown">Category:</label>
            <select defaultValue="" onChange={filterByCategory}>
                
                {/*------------------Coupon Category DropDown Menu---------------*/}
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
            
            {/*------------------Show The Coupons as Card---------------*/}
            <span> {coupons.map(c => <CouponCard key={c.id} coupon={c} />)} </span>

        </div>
        
    );
    
    //----------------------------------

}

export default CustomerCoupons;
