public class Solution {
    public int compareVersion(String version1, String version2) {
        while (true) {
            int v1PointPos = version1.indexOf(".");
            int v2PointPos = version2.indexOf(".");
            int v1 = Integer.parseInt(version1.substring(0, v1PointPos == -1 ? version1.length() : v1PointPos));
            int v2 = Integer.parseInt(version2.substring(0, v2PointPos == -1 ? version2.length() : v2PointPos));
            version1 = version1.substring(v1PointPos + 1);
            version2 = version2.substring(v2PointPos + 1);
            if (v1 > v2)
                return 1;
            else if (v1 < v2)
                return -1;
            else if (v1PointPos == -1 && v2PointPos == -1)
                return 0;
            else if (v1PointPos == -1) {
                while (v2PointPos != -1) {
                    v2PointPos = version2.indexOf(".");
                    v2 = Integer.parseInt(version2.substring(0, v2PointPos == -1 ? version2.length() : v2PointPos));
                    if (v2 > 0)
                        return -1;
                    version2 = version2.substring(v2PointPos + 1);
                }
                return 0;
            }
            else if (v2PointPos == -1) {
                while (v1PointPos != -1) {
                    v1PointPos = version1.indexOf(".");
                    v1 = Integer.parseInt(version1.substring(0, v1PointPos == -1 ? version1.length() : v1PointPos));
                    if (v1 > 0)
                        return 1;
                    version1 = version1.substring(v1PointPos + 1);
                }
                return 0;
            }
        }
    }
}
