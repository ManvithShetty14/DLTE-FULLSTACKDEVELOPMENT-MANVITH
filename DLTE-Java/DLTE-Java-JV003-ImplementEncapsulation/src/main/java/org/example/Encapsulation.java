package org.example;

public class Encapsulation{
    public static void main(String[] args) {
        customer deposits=new customer();
        deposits.openDeposits();
    }
}
// Inner Class as local member

class customer{
    public void openDeposits(){
      
        class request{
            private String customerName;
            private String PAN;
            private long Aadhaar;
            private String profession;
            private int cibil;
            private long contact;

            public String request() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setProfession(String profession ) {
                this.profession = profession;
            }

            public String getProfession(){
                return profession;
            }


            public long getAadhaar() {
                return Aadhaar;
            }

            public void setAadhaar(long aadhaar) {
                Aadhaar = aadhaar;
            }

            public int getCibil() {
                return cibil;
            }

            public void setCibil(int cibil) {
                this.cibil = cibil;
            }

            public String getPAN() {
                return PAN;
            }

            public void setPAN(String PAN) {
                this.PAN = PAN;
            }

            public long getContact() {
                return contact;
            }

            public void setContact(long contact) {
                this.contact = contact;
            }

            
            public request(){}

            // parameterized constructor
            public request(String customerName,  String PAN,long Aadhaar,String profession,int cibil,long contact)
            {
                this.customerName=customerName;
                this.PAN=PAN;
                this.Aadhaar=Aadhaar;
                this.profession=profession;
                this.cibil=cibil;
                this.contact=contact;
            }
        }

        request req=new request();
        req.setCustomerName("Manvith");
        req.setPAN("QWERTY123");
        req.setAadhaar(111222333);
        req.setProfession("banker");
        req.setContact(997210664);
        System.out.println(req.getCustomerName()+" "+req.getPAN()+" "+req.getAadhaar()+"  "+req.getProfession()+" "+req.getCibil());
        request fde=new request("Shetty","ABCDE567",222333444,"teacher",74884,598423456);
        System.out.println(fde.getCustomerName()+" "+fde.getPAN()+" "+fde.getAadhaar()+" "+fde.getProfession()+" "+fde.getCibil());
        System.out.println("Request for Loan received");
    }

}

