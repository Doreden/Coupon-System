import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { CompanyModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import "./CreateCompany.css";

//----------------------------------------------------------------
// Create Company:
//----------------------------------------------------------------
function CreateCompany(): JSX.Element {

    // Class Variable Using for Form:    
    const { register, handleSubmit, formState } = useForm<CompanyModel>();

    // Using for navigation:
    const navigate = useNavigate();



    async function send(company: CompanyModel) {

        try {
            await adminService.createCompany(company);
            notificationService.success("New Company Created Successfully")
            navigate("/admin/app-companies")
        } catch (err: any) {
            notificationService.error(err);
        }
    }


    //----------------------------------------------------------------
    // Create Company Page:
    //----------------------------------------------------------------
    return (
        <div className="CreateCompany">
            {/*---------------Create Company Form--------------- */}
            <form onSubmit={handleSubmit(send)}>

                {/*---------------Name--------------- */}
                <label>Name: </label>
                <input type="text" placeholder="name"{...register("name", {
                    required: { value: true, message: "Missing name!" },
                    minLength: { value: 2, message: "name must contain minimum 3 chars!" },
                    maxLength: { value: 15, message: "name can contain maximum of 15 chars!" }
                })} />
                <span>{formState.errors?.name?.message}</span>


                {/*---------------Email--------------- */}
                <label>Email: </label>
                <input type="text" placeholder="email@domain.com"{...register("email", {
                    pattern: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
                    required: { value: true, message: "Invalid email!" },
             
                })} />
                <span>{formState.errors?.email?.message}</span> <br />


                {/*---------------Password--------------- */}
                <label>Password: </label>
                <input type="text" placeholder="password"{...register("password", {
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


                <button className="create">Create Company</button>
            </form>
        </div>
    );
}

export default CreateCompany;
