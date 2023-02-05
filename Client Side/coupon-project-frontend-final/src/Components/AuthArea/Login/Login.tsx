import { useForm, useFormState } from "react-hook-form";
import { Navigate, useNavigate } from "react-router-dom";
import CredentialsModel from "../../../Models/CredentialsModel";
import authService from "../../../Services/AuthService";
import notificationService from "../../../Services/NotificationService";
import "./Login.css";

function Login(): JSX.Element {


    const { register, handleSubmit, formState } = useForm<CredentialsModel>(); //Form - using -  npm i react-hook-form

    
    const navigate = useNavigate(); // using -  npm i react-router-dom @types/react-router-dom

    async function send(Credentials: CredentialsModel) {
        try {
            await authService.login(Credentials);
            notificationService.success("Welcome Back!");
            navigate("/home")
        } catch (err: any) {
            notificationService.error("Wrong Email or Password")
        }
    }

    return (
        //-----------------------//
        //XML Login Web Form:
        //-----------------------//
        <div className="Login">
            <form onSubmit={handleSubmit(send)}>

                <h2> 🖊 LOGIN 🖊</h2>

                {/* Choose a Role label */}
                <label>👾 Role: </label>
                <select defaultValue="Role" {...register("role")}>
                    <option value="" disabled>Select Role...</option>
                    <option value="ADMIN">Admin</option>
                    <option value="CUSTOMER">Customer</option>
                    <option value="COMPANY">Company</option>
                </select>

                {/* enter email label */}
                <label>📪 Email: </label>
                <input type="email" placeholder="email@domain.com" {...register("email")} />

                {/* enter password label */}
                <label>🕵🏻‍♂️ Password: </label>
                <input type="password" placeholder="password" {...register("password")} />

                <button>Login</button>

            </form>

        </div>
    );
}

export default Login;
