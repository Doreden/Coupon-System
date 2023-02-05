import { createStore } from "redux";
import CouponModel from "../Models/CouponModel";
import { composeWithDevTools } from "redux-devtools-extension";

//----------------------------------------------------------------//
// 1 - State:
//----------------------------------------------------------------//
export class CompanyState {
  [x: string]: any;
  public coupons: CouponModel[] = [];
}

//----------------------------------------------------------------//
// 2 - Actions Type:
//----------------------------------------------------------------//
export enum CompanyActionTypes {
  FetchCoupons = "FetchCoupons",
  CreateCoupon = "CreateCoupon",
  UpdateCoupon = "UpdateCoupon",
  DeleteCoupon = "DeleteCoupons",
  FetchOneCoupon = "FetchOneCoupons",
}

//----------------------------------------------------------------//
// 3 - Actions Interface:
//----------------------------------------------------------------//
export interface CompanyAction {
  type: CompanyActionTypes;
  payload: any;
}

//----------------------------------------------------------------//
// 4 - Actions Creator:
//----------------------------------------------------------------//
// Get Company Coupons Action:
export function fetchCompanyCouponsAction(coupons: CouponModel[]): CompanyAction {
  return { type: CompanyActionTypes.FetchCoupons, payload: coupons };
}

export function FetchOneCouponAction(coupon: CouponModel): CompanyAction {
  return { type: CompanyActionTypes.FetchOneCoupon, payload: coupon };
}

// Create Company Coupon Action:
export function createCouponAction(coupon: CouponModel): CompanyAction {
  return { type: CompanyActionTypes.CreateCoupon, payload: coupon };
}

// Update Company Coupon Action:
export function updateCouponAction(coupon: CouponModel): CompanyAction {
  return { type: CompanyActionTypes.UpdateCoupon, payload: coupon };
}

// Delete Company Coupon Action:
export function deleteCouponAction(id: number): CompanyAction {
  return { type: CompanyActionTypes.DeleteCoupon, payload: id };
}
//----------------------------------------------------------------//
// 5 - Reducer:
//----------------------------------------------------------------//
export function companiesReducer(
  currentState = new CompanyState(),
  action: CompanyAction
): CompanyState {
  const newState = { ...currentState };

  switch (action.type) {
    case CompanyActionTypes.FetchCoupons:
      newState.coupons = action.payload;
      break;
    
    // case CompanyActionTypes.FetchOneCoupon:
    //   newState.coupons = action.payload

    // Create:
    case CompanyActionTypes.CreateCoupon:
      newState.coupons.push(action.payload);
      break;

    // Update:
    case CompanyActionTypes.UpdateCoupon:
      const indexToUpdate = newState.coupons.findIndex(
        (coupon) => coupon.id === action.payload.id
      );
      if (indexToUpdate >= 0) {
        newState.coupons[indexToUpdate] = action.payload;
      }
      break;

    // Delete:
    case CompanyActionTypes.DeleteCoupon:
      const indexToDelete = newState.coupons.findIndex(
        (coupon) => coupon.id === action.payload
      );
      if (indexToDelete >= 0) {
        newState.coupons.splice(indexToDelete, 1); // 1 because we want to delete only one coupon from the array.
      }
      break;
  }
  return newState;
}

//----------------------------------------------------------------//
// 6 - Store:
//----------------------------------------------------------------//
export const companiesStore = createStore(companiesReducer,composeWithDevTools());
//----------------------------------------------------------------//
