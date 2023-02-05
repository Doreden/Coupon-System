import axios from "axios";
import { SyntheticEvent, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { CustomerModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import CustomerCard from "../../SharedArea/CustomerCard/CustomerCard";
import "./AdminCustomers.css";

function AdminCustomers(): JSX.Element {
    //Class Variables:
    const [originalCustomers, setOriginalCustomers] = useState<CustomerModel[]>([]);
    const [customers, setCustomers] = useState<CustomerModel[]>([]);

    //----------------------------------
    //Show App Customers  Function:
    //----------------------------------
    useEffect(() => {
        console.log(axios.defaults.headers);
        adminService
            .fetchCustomers()
            .then((customers) => {
                setOriginalCustomers([...customers])
                setCustomers([...customers])
            })
            .catch(err => notificationService.error(err));
    }, []);


    //----------------------------------
    //Filter Customers By ID Function:
    //----------------------------------
    function filterById(args: SyntheticEvent) { // SyntheticEvent - wrapper for event arguments
        const input = args.target as HTMLInputElement;
        const customerId = +input.value;
        if (input.value === "") {
            setCustomers(originalCustomers);
        }
        else {
            const filteredCustomers = originalCustomers.filter(c => c.id === customerId);
            setCustomers(filteredCustomers);
        }

    }

    const navigate = useNavigate();

    const navigateCreateCustomer = () => {
        navigate("/admin/create-customer");
    }
    //----------------------------------
    // App Customers Page:
    //----------------------------------
    return (
        <div className="AdminCustomers">
            <button onClick={navigateCreateCustomer} className="createCustomer">Create Customer</button>

            {/*------------------Filtering Option---------------*/}
            {/* <span className="header">Search By ID::</span>
            <span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span> */}

            {/*------------------Filter By Coupon ID---------------*/}
            <label className="customerId">Search By Customer ID:</label> &nbsp;
            <input type="number" onChange={filterById} />

            <hr />
            {/*------------------Show The Customers as Card---------------*/}
            <span>{customers.map(c => <CustomerCard key={c.id} customer={c} />)} </span>

        </div>
    );
}

export default AdminCustomers;
