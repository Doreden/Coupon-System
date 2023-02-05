import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router-dom";
import { setConstantValue } from "typescript";
import { CompanyModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import "./UpdateCompany.css";



//----------------------------------------------------------------
// Update Company:
//----------------------------------------------------------------
function UpdateCompany(): JSX.Element {

    // Class Variable Using for Form:    
    const { register, handleSubmit, formState, setValue } = useForm<CompanyModel>();

    // Using for navigation:
    const navigate = useNavigate();
    const params = useParams();
    const compId = +params.compId;

    //*Update the Company parameters
    useEffect(() => {
        console.log("Company: " + compId);
        //* Get The Company From the App customers list
        adminService.getOneCompany(compId)

            // traversing Customer to his new values:
            .then(company => {
                setValue("name", company.name);
                setValue("email", company.email);
                setValue("password", company.password);
                setValue("role", company.role)
            })
            .catch(err => notificationService.error(err));

    }, []);


    //* Sending(creating) Customer with his new parameters
    async function send(company: CompanyModel) {
        try {
            company.id = compId;
            await adminService.updateCompany(company);
            notificationService.success("Company Has Been Successfully Updated!")
            navigate("/admin/app-companies");
        } catch (err: any) {
            notificationService.error(err);
        }
    }

    //----------------------------------------------------------------
    // Update Company Page:
    //----------------------------------------------------------------
    return (
        <div className="UpdateCompany">
            {/*---------------Create Company Form--------------- */}
            <form onSubmit={handleSubmit(send)}>

                {/*---------------Name--------------- */}
                <label>Name: </label>
                <input type="text" disabled {...register("name", {
                    required: { value: true, message: "Missing name!" },
                    minLength: { value: 2, message: "name must contain minimum 3 chars!" },
                    maxLength: { value: 15, message: "name can contain maximum of 15 chars!" }
                })} />
                <span>{formState.errors?.name?.message}</span>


                {/*---------------Email--------------- */}
                <label>Email: </label>
                <input type="text"{...register("email", {
                    pattern: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
                    required: { value: true, message: "Invalid email!" },
                })} />
                <span>{formState.errors?.email?.message}</span> <br />


                {/*---------------Password--------------- */}
                <label>Password: </label>
                <input type="text"{...register("password", {
                    required: { value: true, message: "Missing password!" },
                    minLength: { value: 5, message: "password must contain minimum 5 chars!" },
                    maxLength: { value: 20, message: "password can contain maximum of 20 chars!" }
                })} />
                <span>{formState.errors?.password?.message}</span>

                {/*---------------Role--------------- */}
                <label>Role: </label>
                <select defaultValue="" {...register("role",)}>
                    <option disabled value="">Select Role</option>
                    <option>COMPANY</option>
                </select>
                <span>{formState.errors?.role?.message}</span>


                <button className="updateCompany">Update Company</button>
            </form>

        </div>
    );
}

export default UpdateCompany;




