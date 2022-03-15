package org.practice.problemsolving;

public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2))
            return 0;

        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int count = (parts1.length > parts2.length) ? parts1.length : parts2.length;
        for(int i=0; i<count ; i++) {
            int part1 = Integer.parseInt((i < parts1.length) ? parts1[i] : "0");
            int part2 = Integer.parseInt((i < parts2.length) ? parts2[i] : "0");

            if(part1 < part2)
                return -1;
            if(part2 < part1)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersions obj = new CompareVersions();
        System.out.println(obj.compareVersion("0.1",  "1.1"));
    }
}
