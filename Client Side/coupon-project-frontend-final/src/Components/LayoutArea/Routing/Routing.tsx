import { Navigate, Route, Routes } from "react-router-dom";
import AdminCompanies from "../../AdminArea/AdminCompanies/AdminCompanies";
import AdminCustomers from "../../AdminArea/AdminCustomers/AdminCustomers";
import CreateCompany from "../../AdminArea/CreateCompany/CreateCompany";
import CreateCustomer from "../../AdminArea/CreateCustomer/CreateCustomer";
import UpdateCompany from "../../AdminArea/UpdateCompany/UpdateCompany";
import UpdateCustomer from "../../AdminArea/UpdateCustomer/UpdateCustomer";
import Login from "../../AuthArea/Login/Login";
import Logout from "../../AuthArea/Logout/Logout";
import CompanyCoupons from "../../CompaniesArea/CompanyCoupons/CompanyCoupons";
import CreateCoupon from "../../CompaniesArea/CreateCoupon/CreateCoupon";
import UpdateCoupon from "../../CompaniesArea/UpdateCoupon/UpdateCoupon";
import BuyCoupons from "../../CustomerArea/BuyCoupons/BuyCoupons";
import CustomerCoupons from "../../CustomerArea/CustomerCoupons/CustomerCoupons";
import Home from "../../HomeArea/Home/Home";
import PageNotFound from "../PageNotFound/PageNotFound";
import "./Routing.css";

function Routing(): JSX.Element {
    return (
        <div className="Routing">

            <Routes>
                {/* --------------------------------------------------- */}
                {/*----------------------Auth Area----------------------*/}
                {/*----------------------Login--------------------------*/}
                <Route path="/login" element={<Login />} />
                {/*----------------------Logout--------------------------*/}
                <Route path="/logout" element={<Logout />} />
                {/* --------------------------------------------------- */}


                {/* --------------------------------------------------- */}
                {/*----------------------Home Area----------------------*/}
                {/*----------------------Home----------------------*/}
                <Route path="/home" element={<Home />} />
                {/* --------------------------------------------------- */}


                {/* --------------------------------------------------- */}
                {/*----------------------Customer Area------------------*/}
                {/*----------------------Customer Coupons---------------*/}
                <Route path="/customers/my-coupons" element={<CustomerCoupons />} />
                {/*----------------------Buy Coupons--------------------*/}
                <Route path="/customers/buy-coupons" element={<BuyCoupons />} />
                {/* --------------------------------------------------- */}

                {/* --------------------------------------------------- */}
                {/*----------------------Company Area-------------------*/}
                {/*----------------------Company Coupons----------------*/}
                <Route path="/companies/company-coupons" element={<CompanyCoupons />} />
                {/*----------------------Create Coupon----------------*/}
                <Route path="/companies/create-coupon" element={<CreateCoupon />} />
                {/*----------------------Update Coupon----------------*/}
                <Route path="/companies/update-coupon/:coupId" element={<UpdateCoupon />} />
                {/* --------------------------------------------------- */}


                {/* --------------------------------------------------- */}
                {/*----------------------Admin Area---------------------*/}
                {/*----------------------View All Companies-------------*/}
                <Route path="/admin/app-companies" element={<AdminCompanies />} />
                {/*----------------------Create New Company-------------*/}
                <Route path="/admin/create-company" element={<CreateCompany />} />
                {/*----------------------Update New Company-------------*/}
                <Route path="/admin/update-company/:compId" element={<UpdateCompany />} />
                {/* --------------------------------------------------- */}
                {/*----------------------View All Customers-------------*/}
                <Route path="/admin/app-customers" element={<AdminCustomers />} />
                {/*----------------------Create New Customer-------------*/}
                <Route path="/admin/create-customer" element={<CreateCustomer />} />
                {/*----------------------Update New Customer-------------*/}
                <Route path="/admin/update-customer/:cusId" element={<UpdateCustomer />} />


                {/* --------------------------------------------------- */}
                {/*----------------------Utils Area---------------------*/}
                {/*----------------------Default Route------------------*/}
                <Route path="/" element={<Navigate to="/home" />} />
                {/*----------------------Page Not Found Route-----------*/}
                <Route path="*" element={<PageNotFound />} />
                {/* --------------------------------------------------- */}



            </Routes>
        </div>
    );
}

export default Routing;
