package sample.ui.main;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {

    @FXML
    private Tab D_tab;

    @FXML
    private JFXTextField DID;

    @FXML
    private Label Dname;

    @FXML
    private Button add_d;

    @FXML
    private Button delete_d;

    @FXML
    private Button view_d;

    @FXML
    private Button modify_d;

    @FXML
    private Button settings_d;

    @FXML
    private Tab C_tab;

    @FXML
    private JFXTextField CID;

    @FXML
    private Label Cname;

    @FXML
    private Label Cphone;

    @FXML
    private Button add_c;

    @FXML
    private Button delete_c;

    @FXML
    private Button view_c;

    @FXML
    private Button modify_c;

    @FXML
    private Button settings_c;

    @FXML
    private Label type;

    @FXML
    private Label model;

    @FXML
    private Label p_price;

    @FXML
    private Label s_price;

    @FXML
    private Button add_p;

    @FXML
    private Button delete_p;

    @FXML
    private Button view_p;

    @FXML
    private Button modify_p;

    @FXML
    void loadAddCustomer(ActionEvent event) {

       loadWindow("/sample/ui/Customer_Tab/AddCustomer/AddCustomer.fxml", "Add New customer");

    }

    @FXML
    void loadAddDepartment(ActionEvent event) {

        loadWindow("/sample/ui/Department_Tab/AddDepartment/AddDepartment.fxml", "Add New Department");

    }

    @FXML
    void loadAddProduct(ActionEvent event) {

        loadWindow("/sample/ui/Product_Tab/AddProduct/AddProduct.fxml" , "Add New Product");

    }

    @FXML
    void loadDeleteCustomer(ActionEvent event) {
        loadWindow("/sample/ui/Customer_Tab/DeleteCustomer/DeleteCustomer.fxml", "Delete customer");


    }

    @FXML
    void loadDeleteDepartment(ActionEvent event) {
        loadWindow("/sample/ui/Department_Tab/DeleteDepartment/DeleteDepartment.fxml", "Delete Department");


    }

    @FXML
    void loadDeleteProduct(ActionEvent event) {
        loadWindow("/sample/ui/Product_Tab/DeleteProduct/DeleteProduct.fxml", "Delete Product");

    }

    @FXML
    void loadModifyCustomer(ActionEvent event) {
        loadWindow("/sample/ui/Customer_Tab/ModifyCustomer/ModifyCustomer.fxml", "Modify Customer");

    }

    @FXML
    void loadModifyDepartment(ActionEvent event) {
        loadWindow("/sample/ui/Department_Tab/ModifyDepartment/ModifyDepartment.fxml", "Modify Department");

    }

    @FXML
    void loadModifyProduct(ActionEvent event) {
        loadWindow("/sample/ui/Product_Tab/ModifyProduct/ModifyProduct.fxml", "Modify Product");

    }

    @FXML
    void loadViewCustomer(ActionEvent event) {
        loadWindow("/sample/ui/Customer_Tab/ViewCustomers/ViewCustomers.fxml", "All Customers");

    }

    @FXML
    void loadViewDepartment(ActionEvent event) {
        loadWindow("/sample/ui/Department_Tab/ViewDepartments/ViewDepartments.fxml", "All Departments");

    }

    @FXML
    void loadViewProducts(ActionEvent event) {
        loadWindow("/sample/ui/Product_Tab/ViewProducts/ViewProducts.fxml", "All Products");

    }


    void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


    @FXML
    private JFXTextField e_id;

    @FXML
    private Label E_name;

    @FXML
    private Label E_phone;

    @FXML
    private Label E_age;

    @FXML
    private Label E_job;

    @FXML
    private Button addE;

    @FXML
    private Button delE;

    @FXML
    private Button viewE;

    @FXML
    private Button modifyE;

    @FXML
    private JFXTextField vID;

    @FXML
    private Label v_add;

    @FXML
    private Label v_phone;

    @FXML
    private Label v_name;

    @FXML
    private Button Add_v;

    @FXML
    private Button del_v;

    @FXML
    private Button view_v;

    @FXML
    private Button modify_v;








    @FXML
    void loadAddVendor(ActionEvent event) {
        loadWindow("/sample/ui/Vendor_Tab/AddVendor/add_Vendor.fxml", "Add New Vendor");

    }






    @FXML
    void loadDeleteEmployee(ActionEvent event) {
        loadWindow("/sample/ui/Employee_Tab/DeleteEmployee/Del_Employee.fxml", "Delete Employee");

    }

    @FXML
    void loadDeleteVendor(ActionEvent event) {
        loadWindow("/sample/ui/Vendor_Tab/DeleteVendor/Del_Vendor.fxml", "Delete Vendor");
    }



    @FXML
    void loadModifyEmployee(ActionEvent event) {
        loadWindow("/sample/ui/Employee_Tab/ModifyEmployee/Modify_Employee.fxml", "Modify Employee");
    }

    @FXML
    void loadModifyVendor(ActionEvent event) {
        loadWindow("/sample/ui/Vendor_Tab/ModifyVendor/Modify_Vendor.fxml", "Modify Vendor");
    }




    @FXML
    void loadViewEmployee(ActionEvent event) {
        loadWindow("/sample/ui/Employee_Tab/ViewEmployee/View_Employee.fxml", "All Employees");
    }

    @FXML
    void loadViewVendor(ActionEvent event) {
        loadWindow("/sample/ui/Vendor_Tab/ViewVendor/View_Vendor.fxml", "All Vendors");
    }


    @FXML
    void loadAddEmployee(ActionEvent event) {
        loadWindow("/sample/ui/Employee_Tab/AddEmployee/add_Employee.fxml", "Add Employee");
    }

    @FXML
    void loadAddInvoice1() {
        loadWindow("/sample/ui/SalesInvoice/AddInvoice/AddInvoice1.fxml","Add Invoice");
    }

    @FXML
    void loadDeleteInvoice() {
        loadWindow("/sample/ui/PurchaseInvoice/DeleteInvoice/DeleteInvoice1.fxml","Delete Invoice");
    }

    @FXML
    void loadDeleteInvoice1() {
        loadWindow("/sample/ui/SalesInvoice/DeleteInvoice/DeleteInvoice1.fxml","Delete Invoice");

    }

    @FXML
    void loadModifyInvoice() {
        loadWindow("/sample/ui/PurchaseInvoice/ModifyInvoice/ModifyInvoice1.fxml","Modify Invoice");

    }

    @FXML
    void loadModifyInvoice1() {
        loadWindow("/sample/ui/SalesInvoice/ModifyInvoice/ModifyInvoice1.fxml","Modify Invoice");
    }

    @FXML
    void loadViewInvoices() {
        loadWindow("/sample/ui/PurchaseInvoice/ViewInvoice/ViewInvoice.fxml","All Invoices");
    }

    @FXML
    void loadViewInvoices1() {
        loadWindow("/sample/ui/SalesInvoice/ViewInvoice/ViewInvoice.fxml","All Invoice");
    }

    @FXML
    void loadAddInvoice() {
        loadWindow("/sample/ui/PurchaseInvoice/AddInvoice/AddInvoice1.fxml","Add Invoice");

    }
}
