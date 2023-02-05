import CredentialsModel from "../Models/CredentialsModel";
import appConfig from "../Utils/Config";
import axios from "axios"; // npm i axios
import { authStore, loginAction, logoutAction } from "../Redux/AuthState";

class AuthService {
  //----------------------------------------------------------------//
  // *Auth service method* //
  //----------------------------------------------------------------//
  //Login method:
  public async login(credentials: CredentialsModel): Promise<void> {
    const response = await axios.post<string>(appConfig.loginUrl, credentials); // installing axios - npm i axios;
    const token = (response.data as any).jwt;
    console.log(token);
    authStore.dispatch(loginAction(token));
  }
  //----------------------------------------------------------------//
  //Logout method:
  //----------------------------------------------------------------//
  public logout(): void {
    authStore.dispatch(logoutAction());
  }
  //----------------------------------------------------------------//
}

// init the class as new one :
const authService = new AuthService();

// export the class for public usage:
export default authService;
