import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { CustomerModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import "./CreateCustomer.css";

//----------------------------------------------------------------
// Create Customer:
//----------------------------------------------------------------
function CreateCustomer(): JSX.Element {

    // Class Variable Using for Form:    
    const { register, handleSubmit, formState } = useForm<CustomerModel>();

    // Using for navigation:
    const navigate = useNavigate();


    async function send(customer: CustomerModel) {

        try {
            await adminService.createCustomer(customer);
            notificationService.success("New Company Created Successfully")
            navigate("/admin/app-customers");
        } catch (err: any) {
            notificationService.error(err);
        }
    }

    const regexp = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);


    //----------------------------------------------------------------
    // Create Company Page:
    //----------------------------------------------------------------

    return (
        <div className="CreateCustomer">
            {/*---------------Create Customer Form--------------- */}
            <form onSubmit={handleSubmit(send)}>

                {/*---------------First Name--------------- */}
                <label>First Name: </label>
                <input type="text" placeholder="first name"{...register("firstName", {
                    required: { value: true, message: "Missing name!" },
                    minLength: { value: 1, message: "first name must contain minimum 2 chars!" },
                    maxLength: { value: 15, message: "name can contain maximum of 15 chars!" }
                })} />
                <span>{formState.errors?.firstName?.message}</span>

                {/*---------------Last Name--------------- */}
                <label>Last Name: </label>
                <input type="text" placeholder="last name"{...register("lastName", {
                    required: { value: true, message: "Missing last name!" },
                    minLength: { value: 1, message: "last name must contain minimum 2 chars!" },
                    maxLength: { value: 15, message: "name can contain maximum of 20 chars!" }
                })} />
                <span>{formState.errors?.lastName?.message}</span>

                {/*---------------Email--------------- */}
                <label>Email: </label>
                <input type="text" placeholder="email" {...register("email", {
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
                    <option>CUSTOMER</option>
                </select>
                <span>{formState.errors?.role?.message}</span>


                <button className="create">Create Customer</button>
            </form>
        </div>
    );
}

export default CreateCustomer;
