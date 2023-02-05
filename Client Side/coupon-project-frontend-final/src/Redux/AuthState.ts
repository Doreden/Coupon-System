import jwtDecode from "jwt-decode";
import { createStore } from "redux";
import { BaseUserModel } from "../Models/UserModel";
//----------------------------------------------------------------
//1.State
//----------------------------------------------------------------
export class AuthState {
  public token: string = null;
  public user: BaseUserModel = null;

  public constructor() {
    this.token = localStorage.getItem("token");
    if (this.token) {
      const container: { user: BaseUserModel } = jwtDecode(this.token);
      this.user = container.user;
      console.log(1,this.user);
    }
  }
}
//----------------------------------------------------------------
//2. Action Type
//----------------------------------------------------------------
export enum AuthActionType {
  Login,
  Logout,
}
//----------------------------------------------------------------
//3. Action
//----------------------------------------------------------------
export interface AuthAction {
  type: AuthActionType;
  payload?: string;
}

//----------------------------------------------------------------
//4. Action Creator:
//----------------------------------------------------------------
// Login Action:
export function loginAction(token: string): AuthAction {
  return {
    type: AuthActionType.Login,
    payload: token,
  };
}

// Logout Action:
export function logoutAction(): AuthAction {
  return {
    type: AuthActionType.Logout,
  };
}

//----------------------------------------------------------------
//5. Reducer:
//----------------------------------------------------------------
export function authReducer(
  currentState = new AuthState(),action: AuthAction): AuthState {
    // Create a Copy of the currentState object
  const newState = { ...currentState };
 
  //switch case:
  switch (action.type) {
    //in case of login action
    case AuthActionType.Login:
      newState.token = action.payload;
      const container: { user: BaseUserModel } = jwtDecode(newState.token); // using - npm i jwt-decode
      console.log("container:", container);
      newState.user = container.user;
      console.log("User:", newState.user);
      localStorage.setItem("token", newState.token);
      break;

    //in case of logout action
    case AuthActionType.Logout:
      newState.token = null;
      newState.user = null;
      localStorage.removeItem("token");
      break;
  }
  return newState;
}
//----------------------------------------------------------------
//6. Store: - npm i redux
//----------------------------------------------------------------
export const authStore = createStore(authReducer);

//----------------------------------------------------------------
