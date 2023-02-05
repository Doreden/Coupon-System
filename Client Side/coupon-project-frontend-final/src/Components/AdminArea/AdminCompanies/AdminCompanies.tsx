import axios from "axios";
import { SyntheticEvent, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { CompanyModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import CompanyCard from "../../SharedArea/CompanyCard/CompanyCard";
import "./AdminCompanies.css";

function AdminCompanies(): JSX.Element {
    //Class Variables:
    const [originalCompanies, setOriginalCompanies] = useState<CompanyModel[]>([]);
    const [companies, setCompanies] = useState<CompanyModel[]>([]);

    
    useEffect(() => { 
        console.log(axios.defaults.headers);
        adminService
            .fetchCompanies()
            .then((companies) => { 
                setOriginalCompanies([...companies])
                setCompanies([...companies]);
            })
            .catch(err => notificationService.error(err));
    }, []);



    //----------------------------------
    //Filter Customers By ID Function:
    //----------------------------------
    function filterById(args: SyntheticEvent) { // SyntheticEvent - wrapper for event arguments
        const input = args.target as HTMLInputElement;
        const companyId = +input.value;
        if (input.value === "") {
            setCompanies(originalCompanies);
        }
        else {
            const filteredCompanies = originalCompanies.filter(c => c.id === companyId);
            setCompanies(filteredCompanies);
        }

    }
    const navigate = useNavigate();

    const navigateCreateCompany = () => {
        navigate("/admin/create-company");
    }
    //----------------------------------
    // App Companies Page:
    //----------------------------------
    return (
        <div className="AdminCompanies">
            <button onClick={navigateCreateCompany} className="createCompany">Create Company</button>



            {/*------------------Filter By Coupon ID---------------*/}
            <label className="companyId">Search By Company ID:</label> &nbsp;&nbsp;
            <input type="number" onChange={filterById} />

            <hr />
            
            {/*------------------Show The Companies as Card---------------*/}
            <span>{companies.map(c => <CompanyCard key={c.id} company={c} />)}</span>
            
        </div>
    );
}

export default AdminCompanies;
