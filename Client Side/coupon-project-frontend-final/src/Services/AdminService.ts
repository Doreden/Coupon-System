import axios from "axios";
import { CompanyModel, CustomerModel } from "../Models/UserModel";
import {
  adminStore,
  createCompanyAction,
  createCustomerAction,
  deleteCustomerAction,
  fetchCompaniesAction,
  fetchCustomersAction,
  updateCompanyAction,
  updateCustomerAction,
} from "../Redux/AdminState";
import { companiesStore } from "../Redux/CompanyState";
import appConfig from "../Utils/Config";

class AdminService {
  //--------------------------------------------------------------------------------
  // Admin Service Methods:
  //--------------------------------------------------------------------------------
  //* Admin To Companies Methods:
  //--------------------------------------------------------------------------------
  // Get All Companies:
  //--------------------------------------------------------------------------------
  public async fetchCompanies(): Promise<CompanyModel[]> {
    let companies = adminStore.getState().companies;
    if (companies.length === 0) {
      const response = await axios.get<CompanyModel[]>(
        appConfig.adminCompaniesUrl
      );
      companies = response.data;
      adminStore.dispatch(fetchCompaniesAction(companies));
    }
    return companies;
  }

  //--------------------------------------------------------------------------------
  // Get One Company By ID:
  //--------------------------------------------------------------------------------
  public async getOneCompany(id: number): Promise<CompanyModel> {
    let companies = adminStore.getState().companies;
    const response = await axios.get<CompanyModel>(
      appConfig.adminGetOneCompanyUrl + id
    );
    const company = response.data;
    return company;
  }

  // --------------------------------------------------------------------------------
  // Admin Create Company Methods:
  // --------------------------------------------------------------------------------
  public async createCompany(company: CompanyModel): Promise<CompanyModel> {
    const response = await axios.post<CompanyModel>(
      appConfig.adminCreateCompanyUrl,
      company
    );
    const createdCompany = response.data;
    console.log(createdCompany);
    adminStore.dispatch(createCompanyAction(createdCompany));

    return createdCompany;
  }

  // --------------------------------------------------------------------------------
  // Admin Update Company Methods:
  // --------------------------------------------------------------------------------
  public async updateCompany(company: CompanyModel): Promise<CompanyModel> {
    const response = await axios.put<CompanyModel>(
      appConfig.adminUpdateCompanyUrl,
      company
    );

    const updatedCompany = response.data;
    adminStore.dispatch(updateCompanyAction(updatedCompany));
    return updatedCompany;
  }

  // --------------------------------------------------------------------------------
  // Admin Delete Company Methods:
  // --------------------------------------------------------------------------------
  public async deleteCompany(id: number): Promise<void> {
    // get all app customers list
    let companies = adminStore.getState().companies;

    // Delete in server:
    await axios.delete(appConfig.adminDeleteCompanyUrl + id);

    // Delete in redux global state:
    adminStore.dispatch(deleteCustomerAction(id));
  }

  //--------------------------------------------------------------------------------
  //* Admin To Customers Methods:
  //--------------------------------------------------------------------------------
  //--------------------------------------------------------------------------------
  // Get All Customers:
  //--------------------------------------------------------------------------------
  public async fetchCustomers(): Promise<CustomerModel[]> {
    let customers = adminStore.getState().customers;
    if (customers.length === 0) {
      const response = await axios.get<CustomerModel[]>(
        appConfig.adminCustomersUrl
      );
      customers = response.data;
      adminStore.dispatch(fetchCustomersAction(customers));
    }
    return customers;
  }

  //--------------------------------------------------------------------------------
  // Get One Customer By ID:
  //--------------------------------------------------------------------------------
  public async getOneCustomer(id: number): Promise<CustomerModel> {
    let customers = adminStore.getState().companies;
    const response = await axios.get<CustomerModel>(
      appConfig.adminCreateCustomerUrl + id
    );
    const customer = response.data;
    return customer;
  }

  // --------------------------------------------------------------------------------
  // Admin Create Customer Methods:
  // --------------------------------------------------------------------------------
  public async createCustomer(customer: CustomerModel): Promise<CustomerModel> {
    const response = await axios.post<CustomerModel>(
      appConfig.adminCreateCustomerUrl,
      customer
    );
    const createdCustomer = response.data;
    console.log(createdCustomer);
    adminStore.dispatch(createCustomerAction(createdCustomer));

    return createdCustomer;
  }

  // --------------------------------------------------------------------------------
  // Admin Update Customer Methods:
  // --------------------------------------------------------------------------------
  public async updateCustomer(customer: CustomerModel): Promise<CustomerModel> {
    const response = await axios.put<CustomerModel>(
      appConfig.adminUpdateCustomerUrl,
      customer
    );

    const updatedCustomer = response.data;
    adminStore.dispatch(updateCustomerAction(updatedCustomer));
    return updatedCustomer;
  }

  // --------------------------------------------------------------------------------
  // Admin Delete Customer Methods:
  // --------------------------------------------------------------------------------
  public async deleteCustomer(id: number): Promise<void> {
    // get all app customers list
    let customers = adminStore.getState().customers;

    // Delete in server:
    await axios.delete(appConfig.adminDeleteCustomerUrl + id);

    // Delete in redux global state:
    adminStore.dispatch(deleteCustomerAction(id));
  }
}

const adminService = new AdminService();

export default adminService;
