import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Pilhoyde {

    private Double vinkel;
    private Double radius;
    private Double hoeyde;
    private Double korde;

    public double getVinkel() throws Exception {
        if (vinkel == null) {
            if (radius != null && korde != null) {
                return 180 * 2 * asin(korde / radius / 2) / PI;
            } else if (hoeyde != null && korde != null) {
                double tempRadius = (korde * korde) / (8 * hoeyde) + hoeyde / 2;
                return 180 * 2 * asin(korde / tempRadius / 2) / PI;
            } else if (hoeyde != null && radius != null) {
                throw new Exception("<> Huff og huff, har ikke lært å finne vinkel fra radius og høyde <>");
            } else {
                throw new Exception("<> Huff og huff, har ikke nok data til å finne vinkelen <>");
            }
        } else {
            return vinkel;
        }
    }

    public double getRadius() throws Exception {
        if (radius == null) {
            if (hoeyde != null && korde != null) {
                return (korde * korde) / (8 * hoeyde) + hoeyde / 2;
            } else if (hoeyde != null && vinkel != null) {
                throw new Exception("<> Huff og huff, har ikke lært å finne radius fra vinkel og høyde <>");
            } else if (vinkel != null && korde != null) {
                throw new Exception("<> Huff og huff, har ikke lært å finne radius fra vinkel og korde <>");
            } else {
                throw new Exception("<> Huff og huff, har ikke nok data til å finne vinradiuskelen <>");
            }
        } else {
            return radius;
        }
    }

    public double getHoeyde() throws Exception {
        if (hoeyde == null) {
            if (radius != null && korde != null) {
                return radius * (1 - sqrt(1 - ((korde * korde) / (radius * radius) / 4)));
            } else if (radius != null && vinkel != null) {
                double alpha = sin(PI * vinkel / 2 / 180);
                return radius * (1 - sqrt(1 - (alpha * alpha)));
            } else if (vinkel != null && korde != null) {
                throw new Exception("<> Huff og huff, har ikke lært å finne høyde fra vinkel og korde <>");
            } else {
                throw new Exception("<> Huff og huff, har ikke nok data til å finne høyde <>");
            }
        } else {
            return hoeyde;
        }
    }

    public double getKorde() throws Exception {
        if (korde == null) {
            if (radius != null && vinkel != null) {
                return 2 * sin(PI * vinkel / 2 / 180) * radius;
            } else if (radius != null && hoeyde != null) {
                throw new Exception("<> Huff og huff, har ikke lært å finne korde fra radius og hoeyde <>");
            } else if (vinkel != null && hoeyde != null) {
                throw new Exception("<> Huff og huff, har ikke lært å finne korde fra vinkel og hoeyde <>");
            } else {
                throw new Exception("<> Huff og huff, har ikke nok data til å finne korde <>");
            }
        } else {
            return korde;
        }
    }

    public void setVinkel(Double vinkel) {
        this.vinkel = vinkel;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void setHoeyde(Double hoeyde) {
        this.hoeyde = hoeyde;
    }

    public void setKorde(Double korde) {
        this.korde = korde;
    }

    public void print() throws Exception {
        DecimalFormat decimalFormat = new DecimalFormat("#.0#");
        System.out.print("Vinkel= " + decimalFormat.format(getVinkel()));
        System.out.print(", radius= " + decimalFormat.format(getRadius()));
        System.out.print(", høyde= " + decimalFormat.format(getHoeyde()));
        System.out.println(", korde= " + decimalFormat.format(getKorde()));
    }
}
