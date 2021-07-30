import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableTest {

    public static void main(String[] args) {
        String[] skills = new String[]{"java", "spring"};
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("halasuru", "bangalore"));
        Immutable immutable= null;
        try {
            immutable = new Immutable(123, "Eswar", skills, addresses);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        skills[1] = "aaaaaaaa";

        String[] skillsFromImmutable = immutable.getSkills();
        skillsFromImmutable[1] = "bbbbbbb";

        List<Address> newAddresses = null;
        try {
            newAddresses = immutable.getAddresses();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        newAddresses.set(0, new Address("main road", "kurupam"));

        System.out.println(immutable.toString());
    }


    private static class Immutable {
        private final int id;
        private final String name;
        private final String[] skills;
        private final List<Address> addresses;


        public Immutable(int id, String name, String[] skills, List<Address> addresses) throws CloneNotSupportedException {
            this.id = id;
            this.name = name;
//            this.skills = skills;  // This is wrong. If the passed skills arguemnt is changed later, this object gets updated.
            this.skills = skills.clone();

            this.addresses = new ArrayList<Address>();
            for(Address address : addresses) {
                this.addresses.add((Address) address.clone());
            }
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String[] getSkills() {
//            return skills; //This is wrong.
            return skills.clone();
        }

        public List<Address> getAddresses() throws CloneNotSupportedException {
            List<Address> addresses = new ArrayList<Address>();
            for(Address address : this.addresses) {
                addresses.add((Address) address.clone());
            }
            return addresses;
        }

//        @Override
//        public String toString() {
//            return "Immutable{" +
//                    "id=" + id +
//                    ", name='" + name + '\'' +
//                    ", skills=" + Arrays.toString(skills) +
//                    '}';
//        }


        @Override
        public String toString() {
            return "Immutable{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", skills=" + Arrays.toString(skills) +
                    ", addresses=" + addresses +
                    '}';
        }
    }

    private static class Address {
        private String addressLine1;
        private String addressLine2;

        public Address(String addressLine1, String addressLine2) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Address(this.addressLine1, this.addressLine2);
        }

        @Override
        public String toString() {
            return "Address{" +
                    "addressLine1='" + addressLine1 + '\'' +
                    ", addressLine2='" + addressLine2 + '\'' +
                    '}';
        }
    }


}

