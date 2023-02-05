import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import Role from "../../../Models/Role";
import { BaseUserModel, CompanyModel, CustomerModel } from "../../../Models/UserModel";
import { authStore } from "../../../Redux/AuthState";
import "./AuthMenu.css";
//----------------------------------------------------------------//
// Authorization Menu Function:
//----------------------------------------------------------------//
function AuthMenu(): JSX.Element {

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
    // Get Detail Function:
    //----------------------------------------------------------------//
    function getDetails(): string {
        //Switch Case - For Different Roles:
        switch (user.role) {
            //case - Role = Customer:
            case Role.CUSTOMER:
                const customer = user as CustomerModel;
                return "🧑🏼‍💻 My Details: " + customer.firstName + " "+ customer.lastName +"   |   " + customer.email;
                
            //case - Role = Company:
            case Role.COMPANY:
                const company = user as CompanyModel;
                return "👔 My Details: " + company.name + " |  " + company.email;

            //Default Case:
            default:
                return "🎩 Admin: " + user.email;
        }
    }


    //----------------------------------------------------------------//
    // Authorization Menu:
    //----------------------------------------------------------------//    
    return (
        <div className="AuthMenu">
            {
                !user && <>
                    <span>Hello Guest | </span>
                    <NavLink to="/login">Login</NavLink>
                </>
            }

            {
                user && <>
                    <span>{getDetails()} | </span>
                    <NavLink to="/logout">Logout</NavLink>
                </>
            }


        </div>
    );
    //----------------------------------------------------------------//    

}

export default AuthMenu;
