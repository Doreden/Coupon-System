class Config {}

class DevelopmentConfig extends Config {

  //----------------------------------------------------------------
  // Authentication URLS:
  //----------------------------------------------------------------
  public loginUrl = "http://localhost:8080/authentication/login";

  //----------------------------------------------------------------
  // Customers URLS:
  //----------------------------------------------------------------
  public customersMyCouponsUrl = "http://localhost:8080/customer/";
  public customersOtherCouponsUrl = "http://localhost:8080/customer/";
  public customersBuyCouponUrl = "http://localhost:8080/customer/";
  public customerDetailsUrl = "http://localhost:8080/customer/details/";

  //----------------------------------------------------------------
  // Company URLS:
  //----------------------------------------------------------------
  public companyCouponsUrl = "http://localhost:8080/company/coupons/";
  public companyCreateCouponUrl = "http://localhost:8080/company/";
  public companyUpdateCouponUrl = "http://localhost:8080/company/";
  public companyDeleteCouponUrl = "http://localhost:8080/company/";
  public companyGetOneCouponUrl = "http://localhost:8080/company/";
  public companyDetailsUrl = "http://localhost:8080/company/details/";

  //----------------------------------------------------------------
  // Admin URLS:
  //----------------------------------------------------------------
  public adminCompaniesUrl = "http://localhost:8080/admin/companies/";
  public adminGetOneCompanyUrl = "http://localhost:8080/admin/company/";
  public adminCreateCompanyUrl = "http://localhost:8080/admin/company/";
  public adminUpdateCompanyUrl = "http://localhost:8080/admin/company/";
  public adminDeleteCompanyUrl = "http://localhost:8080/admin/company/";

  public adminCustomersUrl = "http://localhost:8080/admin/customers/";
  public adminGetOneCustomerUrl = "http://localhost:8080/admin/customer/";
  public adminCreateCustomerUrl = "http://localhost:8080/admin/customer/";
  public adminUpdateCustomerUrl = "http://localhost:8080/admin/customer/";
  public adminDeleteCustomerUrl = "http://localhost:8080/admin/customer/";
}

class ProductionConfig extends Config {
  //----------------------------------------------------------------
  // Authentication URLS:
  //----------------------------------------------------------------
  public loginUrl = "http://localhost:8080/authentication/login";

  //----------------------------------------------------------------
  // Customers URLS:
  //----------------------------------------------------------------
  public customersMyCouponsUrl = "http://localhost:8080/customer/";
  public customersOtherCouponsUrl = "http://localhost:8080/customer/";
  public customersBuyCouponUrl = "http://localhost:8080/customer/";
  public customerDetailsUrl = "http://localhost:8080/customer/details/";

  //----------------------------------------------------------------
  // Company URLS:
  //----------------------------------------------------------------
  public companyCouponsUrl = "http://localhost:8080/company/coupons/";
  public companyCreateCouponUrl = "http://localhost:8080/company/";
  public companyUpdateCouponUrl = "http://localhost:8080/company/";
  public companyDeleteCouponUrl = "http://localhost:8080/company/";
  public companyGetOneCouponUrl = "http://localhost:8080/company/";
  public companyDetailsUrl = "http://localhost:8080/company/details/";

  //----------------------------------------------------------------
  // Admin URLS:
  //----------------------------------------------------------------
  public adminCompaniesUrl = "http://localhost:8080/admin/companies/";
  public adminGetOneCompanyUrl = "http://localhost:8080/admin/company/";
  public adminCreateCompanyUrl = "http://localhost:8080/admin/company/";
  public adminUpdateCompanyUrl = "http://localhost:8080/admin/company/";
  public adminDeleteCompanyUrl = "http://localhost:8080/admin/company/";

  public adminCustomersUrl = "http://localhost:8080/admin/customers/";
  public adminGetOneCustomerUrl = "http://localhost:8080/admin/customer/";
  public adminCreateCustomerUrl = "http://localhost:8080/admin/customer/";
  public adminUpdateCustomerUrl = "http://localhost:8080/admin/customer/";
  public adminDeleteCustomerUrl = "http://localhost:8080/admin/customer/";
}

const appConfig =
  process.env.NODE_ENV === "development"
    ? new DevelopmentConfig()
    : new ProductionConfig();

export default appConfig;
