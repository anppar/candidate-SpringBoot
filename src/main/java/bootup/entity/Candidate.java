package bootup.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by anoop on 29/11/17.
 */
public class Candidate {

    @Id
    private String id;

    private String name;

    private String address;

    private String jobTitle;

    private int age;

    private int experiance;

    public Candidate(String id, String name, String address, String jobTitle, int age, int experiance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.jobTitle = jobTitle;
        this.age = age;
        this.experiance = experiance;
    }

    public Candidate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    @Override
    public String toString() {
        return String.format(
                "Candidate[id=%s, Name='%s', Age='%s', Experiance='%s', JobTitle='%s', Address='%s']",
                id, name, age, experiance, jobTitle, address);
    }
}
