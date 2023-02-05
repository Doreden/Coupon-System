import { ProductionQuantityLimits } from "@mui/icons-material";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import CouponModel from "../../../Models/CouponModel";
import companiesService from "../../../Services/CompaniesService";
import notificationService from "../../../Services/NotificationService";
import "./CreateCoupon.css";
//----------------------------------------------------------------
// Create Coupon:
//----------------------------------------------------------------
function CreateCoupon(): JSX.Element {

    // Class Variable Using for Form:    
    const { register, handleSubmit, formState } = useForm<CouponModel>();

    // Using for navigation:
    const navigate = useNavigate();


    async function send(coupon: CouponModel) {

        try {
            await companiesService.createCoupon(coupon);
            notificationService.success("New Coupon Created Successfully")
            navigate("/companies/company-coupons")
        } catch (err: any) {
            notificationService.error(err);
        }
    }

    //----------------------------------------------------------------
    // Create Coupon Page:
    //----------------------------------------------------------------
    return (
        <div className="CreateCoupon">
            {/*---------------Create Coupon Form--------------- */}
            <form onSubmit={handleSubmit(send)}>
                {/*---------------Title--------------- */}
                <label>Title: </label>
                <input type="text" placeholder="title"{...register("title", {
                    required: { value: true, message: "Missing title!" },
                    minLength: { value: 2, message: "title must contain minimum 3 chars!" },
                    maxLength: { value: 100, message: "title can contain maximum of 30 chars!" }
                })} />
                <span>{formState.errors?.title?.message}</span>



                {/*---------------Category--------------- */}
                <label>Category: </label>
                <select defaultValue="" {...register("category",)}>
                    <option disabled value="">Select Category</option>
                    <option>FOOD</option>
                    <option>BEVERAGE</option>
                    <option>JUNKFOOD</option>
                    <option>SPORTS</option>
                    <option>TRAVEL</option>
                    <option>ELECTRONICS</option>
                    <option>RESTAURANTS</option>
                    <option>VACATION</option>
                    <option>CLOTHING</option>
                    <option>SHOES</option>
                    <option>OTHERS</option>
                </select>

                <span>{formState.errors?.category?.message}</span>

                {/*---------------Description--------------- */}
                <label>Description: </label>
                <input type="text" placeholder="description"{...register("description", {
                    required: { value: true, message: "Missing description!" },
                    minLength: { value: 2, message: "description must contain minimum 3 chars!" },
                    maxLength: { value: 100, message: "description can contain maximum of 30 chars!" }

                })} />
                <span>{formState.errors?.description?.message}</span>

                {/*---------------Start Date--------------- */}
                <label>Start Date: </label>
                <input type="date"{...register("startDate", {
                    min: { value: 2022 - 10 - 19, message: "Start Date Has Been Passed!" },
                    max: { value: 2022 - 12 - 19, message: "Coupon Period cannot start in more than 2 months!  " }
                })} />
                < span > {formState.errors?.startDate?.message}</span>

                {/*---------------End Date--------------- */}
                <label>End Date: </label>
                <input type="date"{...register("endDate", {
                    min: { value: 2022 - 10 - 19, message: "End Date Has Been Passed!" },
                    max: { value: 2023 - 10 - 19, message: "Coupon Period Cannot End In More Than a Year!  " }
                })} />
                <span>{formState.errors?.endDate?.message}</span>

                {/*---------------Amount--------------- */}
                <label>Amount: </label>
                <input type="number" placeholder="amount"{...register("amount", {
                    required: { value: true, message: "Missing Stock!" },
                    min: { value: 0, message: "Amount can't be negative!" },
                    max: { value: 10000, message: "Amount can't contain more than 1000" },
                })} />
                <span>{formState.errors?.amount?.message}</span>


                {/*---------------Price--------------- */}
                <label>Price: </label>
                <input type="number" placeholder="$0.00" step="0.01" {...register("price", {
                    required: { value: true, message: "Missing price" },
                    min: { value: 0, message: "Price can't be negative" },
                    max: { value: 1000, message: "Price must be less than 1000" }
                })} />
                <span>{formState.errors?.price?.message}</span>

                {/*---------------Image--------------- */}
                <label>Image URL: </label>
                <input type="text" placeholder="image url" {...register("image")} />
                <span>{formState.errors?.image?.message}</span>

                <button className="create">Create Coupon</button>
            </form>
        </div >

    );
}

export default CreateCoupon;
