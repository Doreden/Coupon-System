import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router-dom";
import { CustomerModel } from "../../../Models/UserModel";
import adminService from "../../../Services/AdminService";
import notificationService from "../../../Services/NotificationService";
import CouponCard from "../../SharedArea/CouponCard/CouponCard";
import "./UpdateCustomer.css";

//----------------------------------------------------------------
// Update Customer:
//----------------------------------------------------------------
function UpdateCustomer(): JSX.Element {


    // Class Variable Using for Form:    
    const { register, handleSubmit, formState, setValue } = useForm<CustomerModel>();


    const navigate = useNavigate();
    const params = useParams();
    const cusId = +params.cusId;

    //*Update the customer parameters
    useEffect(() => {
        console.log("Customer: " + cusId);
        //* Get The Customer From the App customers list
        adminService.getOneCustomer(cusId)
            // traversing Customer to his new values:
            .then(customer => {
                setValue("firstName", customer.firstName);
                setValue("lastName", customer.lastName);
                setValue("email", customer.email);
                setValue("password", customer.password);
                setValue("role", customer.role)
            })
            .catch(err => notificationService.error(err));

    }, []);

    //* Sending(creating) Customer with his new parameters
    async function send(customer: CustomerModel) {
        try {
            customer.id = cusId;
            await adminService.updateCustomer(customer);
            notificationService.success("Customer Has Been Successfully Updated!")
            navigate("/admin/app-customers");
        } catch (err: any) {
            notificationService.error(err);
        }
    }



    return (
        <div className="UpdateCustomer">
            {/*---------------Create Customer Form--------------- */}
            <form onSubmit={handleSubmit(send)}>

                {/*---------------First Name--------------- */}
                <label>First Name: </label>
                <input type="text"{...register("firstName", {
                    required: { value: true, message: "Missing name!" },
                    minLength: { value: 1, message: "first name must contain minimum 2 chars!" },
                    maxLength: { value: 15, message: "name can contain maximum of 15 chars!" }
                })} />
                <span>{formState.errors?.firstName?.message}</span>

                {/*---------------Last Name--------------- */}
                <label>Last Name: </label>
                <input type="text"{...register("lastName", {
                    required: { value: true, message: "Missing last name!" },
                    minLength: { value: 1, message: "last name must contain minimum 2 chars!" },
                    maxLength: { value: 15, message: "name can contain maximum of 20 chars!" }
                })} />
                <span>{formState.errors?.lastName?.message}</span>

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
                    <option>CUSTOMER</option>
                </select>
                <span>{formState.errors?.role?.message}</span>


                <button className="updateCustomer">Update Customer</button>
            </form>
        </div>
    );
}

export default UpdateCustomer;
