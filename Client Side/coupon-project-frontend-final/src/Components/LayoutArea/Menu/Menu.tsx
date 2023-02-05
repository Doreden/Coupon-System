import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import Role from "../../../Models/Role";
import { BaseUserModel } from "../../../Models/UserModel";
import { authStore } from "../../../Redux/AuthState";
import customerMenuImage from "../../../Assets/minimal blue sky.png";

import "./Menu.css";


//----------------------------------------------------------------//
// Main Menu Function:
//----------------------------------------------------------------//
function Menu(): JSX.Element {

    const [user, setUser] = useState<BaseUserModel>();

    useEffect(() => {
        setUser(authStore.getState().user);

        const unsubscribe = authStore.subscribe(() => {
            setUser(authStore.getState().user);
        });

        return () => {
            unsubscribe();
        }
    },
        []);



    //----------------------------------------------------------------//
    // Main Menu:
    //----------------------------------------------------------------//
    return (
        <div className="Menu">


            {user?.role === Role.CUSTOMER &&

                <>
                    <span className="customerMenu">Customer Menu</span>
                <NavLink to="/customers/my-coupons"> My Coupons</NavLink>
                <NavLink to="/customers/buy-coupons">Buy Coupons</NavLink>


                </>
            }

            {user?.role === Role.COMPANY &&
                <>
                    <span className="companyMenu">Company Menu</span>
                <NavLink to="/companies/company-coupons"> My Coupons</NavLink>

                </>
            }

            {user?.role === Role.ADMIN &&
                <>
                    <span className="adminMenu">Admin Menu</span>
                    <NavLink to="/admin/app-customers">App Customers</NavLink>

                    <NavLink to="/admin/app-companies">App Companies</NavLink>
                </>
            }

            <img src={customerMenuImage} />

        </div>
    );
}

export default Menu;
