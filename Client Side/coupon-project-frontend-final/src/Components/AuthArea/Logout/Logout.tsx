import { useEffect } from "react";
import {useNavigate } from "react-router-dom";
import authService from "../../../Services/AuthService";
import notificationService from "../../../Services/NotificationService";
import "./Logout.css";

function Logout(): JSX.Element {
    const navigate = useNavigate();

// Use The navigate Function:
    useEffect(() => {
        authService.logout();
        notificationService.success("Good Bye!");
        navigate("/home")
    }, [])
    
    return null;
}

export default Logout;
