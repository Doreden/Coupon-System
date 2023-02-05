import { createStore } from "redux";
import { composeWithDevTools } from "redux-devtools-extension";
import { CompanyModel, CustomerModel } from "../Models/UserModel";

//----------------------------------------------------------------//
// 1 - State:
//----------------------------------------------------------------//
export class AdminState {
  public companies: CompanyModel[] = [];
  public customers: CustomerModel[] = [];
}

//----------------------------------------------------------------//
// 2 - Action Type:
//----------------------------------------------------------------//
export enum AdminActionTypes {
  //* Company ActionTypes: //
  FetchCompanies = "FetchCompanies",
  FetchOneCompany = "FetchOneCompany",
  CreateCompany = "CreateCompany",
  UpdateCompany = "UpdateCompany",
  DeleteCompany = "DeleteCompany",

  //* Customer ActionTypes: //
  FetchCustomers = "FetchCustomers",
  FetchOneCustomer = "FetchOneCustomer",
  CreateCustomer = "CreateCustomer",
  UpdateCustomer = "UpdateCustomer",
  DeleteCustomer = "DeleteCustomer",
}

//----------------------------------------------------------------//
// 3 - Actions Interface:
//----------------------------------------------------------------//
export interface AdminAction {
  type: AdminActionTypes;
  payload: any;
}

//----------------------------------------------------------------//
// 4 - Actions Creators:
//----------------------------------------------------------------//
//---------------------- Companies Actions ----------------------//
// Fetch Companies Action:
export function fetchCompaniesAction(companies: CompanyModel[]): AdminAction {
  return { type: AdminActionTypes.FetchCompanies, payload: companies };
}

// Fetch One Company Action:
export function FetchOneCompany(company: CompanyModel[]): AdminAction {
  return { type: AdminActionTypes.FetchOneCompany, payload: company };
}

// Create App Company Action:
export function createCompanyAction(company: CompanyModel): AdminAction {
  return { type: AdminActionTypes.CreateCompany, payload: company };
}

// Update App Company Action:
export function updateCompanyAction(company: CompanyModel): AdminAction {
  return { type: AdminActionTypes.UpdateCompany, payload: company };
}

// Delete App Company Action:
export function deleteCompanyAction(id: number): AdminAction {
  return { type: AdminActionTypes.DeleteCompany, payload: id };
}

//---------------------- Customers Actions ----------------------//
//Fetch Customers Function:
export function fetchCustomersAction(customers: CustomerModel[]): AdminAction {
  return { type: AdminActionTypes.FetchCustomers, payload: customers };
}

// Fetch One Customer Action:
export function FetchOneCustomer(customer: CustomerModel[]): AdminAction {
  return { type: AdminActionTypes.FetchOneCustomer, payload: customer };
}

// Create App Customer Action:
export function createCustomerAction(customer: CustomerModel): AdminAction {
  return { type: AdminActionTypes.CreateCustomer, payload: customer };
}

// Update App Customer Action:
export function updateCustomerAction(customer: CustomerModel): AdminAction {
  return { type: AdminActionTypes.UpdateCustomer, payload: customer };
}

// Delete App Customer Action:
export function deleteCustomerAction(id: number): AdminAction {
  return { type: AdminActionTypes.DeleteCustomer, payload: id };
}

//----------------------------------------------------------------//
// 5 - Reducer:
//----------------------------------------------------------------//
export function adminReducer(
  currentState = new AdminState(),
  action: AdminAction
): AdminState {
  const newState = { ...currentState };

  switch (action.type) {
    //*-------- Company Cases: --------//
    // Get All:
    case AdminActionTypes.FetchCompanies:
      newState.companies = action.payload;
      break;

    // Create:
    case AdminActionTypes.CreateCompany:
      newState.companies.push(action.payload);
      break;

    // Update:
    case AdminActionTypes.UpdateCompany:
      const indexToUpdateCompany = newState.companies.findIndex(
        (company) => company.id === action.payload.id
      );
      if (indexToUpdateCompany >= 0) {
        newState.companies[indexToUpdateCompany] = action.payload;
      }
      break;

    // Delete:
    case AdminActionTypes.DeleteCompany:
      const indexToDeleteCompany = newState.companies.findIndex(
        (company) => company.id === action.payload
      );
      if (indexToDeleteCompany >= 0) {
        newState.companies.splice(indexToDeleteCompany, 1); // 1 because we want to delete only one company from the array.
      }
      break;

    //*-------- Customer Cases: --------//
    // Get All:
    case AdminActionTypes.FetchCustomers:
      newState.customers = action.payload;
      break;

    // Create:
    case AdminActionTypes.CreateCustomer:
      newState.customers.push(action.payload);
      break;

    // Update:
    case AdminActionTypes.UpdateCustomer:
      const indexToUpdateCustomer = newState.customers.findIndex(
        (customer) => customer.id === action.payload.id
      );
      if (indexToUpdateCustomer >= 0) {
        newState.customers[indexToUpdateCustomer] = action.payload;
      }
      break;

    // Delete:
    case AdminActionTypes.DeleteCustomer:
      const indexToDeleteCustomer = newState.companies.findIndex(
        (customer) => customer.id === action.payload
      );
      if (indexToDeleteCustomer >= 0) {
        newState.customers.splice(indexToDeleteCustomer, 1); // 1 because we want to delete only one customer from the array.
      }
      break;
  }

  return newState;
}

//----------------------------------------------------------------//
// 6 - Store:
//----------------------------------------------------------------//
export const adminStore = createStore(adminReducer, composeWithDevTools());
//----------------------------------------------------------------//
