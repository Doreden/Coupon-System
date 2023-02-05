import { useNavigate } from "react-router-dom";
import { CompanyModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import "./CompanyCard.css";


interface CompanyCardProps {
    company: CompanyModel;
}


function CompanyCard(props: CompanyCardProps): JSX.Element {

    const navigate = useNavigate();
    const navigateForDelete = useNavigate();

    const navigateUpdateCompany = () => {
        navigate("/admin/update-company/" + props.company.id);
    };

    const navigateDeleteCompany = () => {
        try {
            adminService.deleteCompany(props.company.id);
            notificationService.success("Company Deleted Successfully");
            navigate("/admin/app-companies");
        }
        catch (err: any) {
            notificationService.error(err);
        }
    };

    return (

        <div className="CompanyCard">

            <span className="name">{props.company.name}</span> <br />
            <span className="email">{props.company.email}</span><br />
            <span className="Id">ID: {props.company.id}</span><br />
            <br />


            <button onClick={navigateUpdateCompany} className="edit">Edit</button>
            <button onClick={navigateDeleteCompany} className="delete">Delete </button>

        </div>
    );
}

export default CompanyCard;
