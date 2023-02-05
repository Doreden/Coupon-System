import { useNavigate } from "react-router-dom";
import { CustomerModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import "./CustomerCard.css";

interface CustomerCardProps {
    customer: CustomerModel;
}

function CustomerCard(props: CustomerCardProps): JSX.Element {


    const navigate = useNavigate();
    const navigateForDelete = useNavigate();


    const navigateUpdateCustomer = () => {
        navigate("/admin/update-customer/" + props.customer.id);
    };

    const navigateDeleteCustomer = () => {
        try {
            adminService.deleteCustomer(props.customer.id);
            notificationService.success("Customer deleted successfully");
            navigate("/admin/app-customers");
        }
        catch (err: any) {
            notificationService.error(err)
        }
    };

    return (
        <div className="CustomerCard">

            <span className="firstName">{props.customer.firstName}</span> &nbsp;
            <span className="lastName"> {props.customer.lastName}</span>
            <br />
            <span className="email">{props.customer.email}</span>
            <br />
            <span className="Id">ID: {props.customer.id}</span><br />
            <br />







            <button onClick={navigateUpdateCustomer} className="edit">Edit</button>
            <button onClick={navigateDeleteCustomer} className="delete">Delete </button>

        </div>
    );
}

export default CustomerCard;
