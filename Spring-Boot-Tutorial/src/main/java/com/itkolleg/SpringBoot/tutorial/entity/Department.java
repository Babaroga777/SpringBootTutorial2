package com.itkolleg.SpringBoot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//Annotation for making this class an entity and to interact with the database
@Entity

//Wichtige Annotation für Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    //Important for setting the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    //Datenfelder
    private Long departmentId;

    /**
     * Different possible Validations
     *
     * @Length(max = 10,min = 0)
     * @Size(max = 10, min = 0)
     * @Email
     * @Positive
     * @Negative
     * @PositiveOrZero
     * @NegativeOrZero
     * @Future
     * @FutureOrPresent
     * @Past
     * @PastOrPresent
     */

    @NotBlank(message = "Please Add Department Name!")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}



    //Konstruktoren
//    public Department() {}
//
//    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//            this.departmentId = departmentId;
//            this.departmentName = departmentName;
//            this.departmentAddress = departmentAddress;
//            this.departmentCode = departmentCode;
//        }
//
//        //toString-Methode
//        @Override
//        public String toString() {
//            return "Department{" +
//                    "departmentId=" + departmentId +
//                    ", departmentName='" + departmentName + '\'' +
//                    ", departmentAddress='" + departmentAddress + '\'' +
//                    ", departmentCode='" + departmentCode + '\'' +
//                    '}';
//        }
//
//        //Getter & Setter
//        public Long getDepartmentId() {
//            return departmentId;
//        }
//
//        public void setDepartmentId(Long departmentId) {
//            this.departmentId = departmentId;
//        }
//
//        public String getDepartmentName() {
//            return departmentName;
//        }
//
//        public void setDepartmentName(String departmentName) {
//            this.departmentName = departmentName;
//        }
//
//        public String getDepartmentAddress() {
//            return departmentAddress;
//        }
//
//        public void setDepartmentAddress(String departmentAddress) {
//            this.departmentAddress = departmentAddress;
//        }
//
//        public String getDepartmentCode() {
//            return departmentCode;
//        }
//
//        public void setDepartmentCode(String departmentCode) {
//            this.departmentCode = departmentCode;
//        }
//}
