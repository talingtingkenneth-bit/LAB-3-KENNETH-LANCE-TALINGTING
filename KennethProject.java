package KennethProject;

import java.util.Scanner;
import static java.lang.Math.*;

public class KennethProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /// PROBLEM 1 ///
        System.out.print("Enter angle in degrees: ");
        double angleDeg1 = input.nextDouble();

        System.out.println("Choose function:");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. All three");
        int choice = input.nextInt();

        double rad3 = toRadians(angleDeg1);

        // Use switch-case instead of long if-else
        switch (choice) {
            case 1:
                System.out.println("Sine(" + angleDeg1 + "°) = " + sin(rad3));
                break;
            case 2:
                System.out.println("Cosine(" + angleDeg1 + "°) = " + cos(rad3));
                break;
            case 3:
                if (abs(cos(rad3)) < 1e-10) {
                    System.out.println("Tangent(" + angleDeg1 + "°) is undefined!");
                } else {
                    System.out.println("Tangent(" + angleDeg1 + "°) = " + tan(rad3));
                }
                break;
            case 4:
                System.out.println("Sine(" + angleDeg1 + "°) = " + sin(rad3));
                System.out.println("Cosine(" + angleDeg1 + "°) = " + cos(rad3));
                if (abs(cos(rad3)) < 1e-10) {
                    System.out.println("Tangent(" + angleDeg1 + "°) is undefined!");
                } else {
                    System.out.println("Tangent(" + angleDeg1 + "°) = " + tan(rad3));
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        /// PROBLEM 2 ///
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();

        angle = ((angle % 360) + 360) % 360;
        System.out.println("Normalized angle: " + angle + "°");

        if (angle == 0 || angle == 180 || angle == 360) {
            System.out.println("On X-axis: sine = 0, cosine = ±1, tangent = 0");
        } else if (angle == 90 || angle == 270) {
            System.out.println("On Y-axis: sine = ±1, cosine = 0, tangent = undefined");
        } else {
            if (angle > 0 && angle < 90) {
                System.out.println("Quadrant I: sin +, cos +, tan +");
            } else if (angle > 90 && angle < 180) {
                System.out.println("Quadrant II: sin +, cos -, tan -");
            } else if (angle > 180 && angle < 270) {
                System.out.println("Quadrant III: sin -, cos -, tan +");
            } else {
                System.out.println("Quadrant IV: sin -, cos +, tan -");
            }
        }

        /// PROBLEM 3 ///
        System.out.println("Right Triangle Solver");
        System.out.println("Choose what you know:");
        System.out.println("1. Two sides");
        System.out.println("2. One side and one angle (< 90°)");
        int choice1 = input.nextInt();

        double a = 0, b = 0, c = 0;
        double A = 0, B = 0, C = 90;

        if (choice1 == 1) {
            System.out.print("Enter side a: ");
            a = input.nextDouble();
            System.out.print("Enter side b: ");
            b = input.nextDouble();

            if (a <= 0 || b <= 0) {
                System.out.println("Invalid input! Sides must be positive.");
                return;
            }

            c = sqrt(pow(a, 2) + pow(b, 2));
            A = toDegrees(atan2(a, b));
            B = 90 - A;

        } else if (choice1 == 2) {
            System.out.print("Enter known side length: ");
            double side = input.nextDouble();
            System.out.print("Enter known angle (< 90°): ");
            double angleA = input.nextDouble();

            if (side <= 0 || angleA <= 0 || angleA >= 90) {
                System.out.println("Invalid input! Side must be positive and angle must be < 90°.");
                return;
            }

            A = angleA;
            B = 90 - A;
            a = side;
            c = a / sin(toRadians(A));
            b = sqrt(pow(c, 2) - pow(a, 2));

        } else {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("\n=== Results ===");
        System.out.printf("Sides: a = %.2f, b = %.2f, c = %.2f%n", a, b, c);
        System.out.printf("Angles: A = %.2f°, B = %.2f°, C = 90°%n", A, B);
        System.out.printf("Area = %.2f%n", 0.5 * a * b);

        /// PROBLEM 4 ///
        System.out.print("Enter angle in degrees: ");
        double angleDeg4 = input.nextDouble();
        double rad5 = toRadians(angleDeg4);
        double tol = 1e-6;

        double lhs1 = pow(sin(rad5), 2) + pow(cos(rad5), 2);
        boolean id1 = abs(lhs1 - 1) < tol;

        double lhs2 = 1 + pow(tan(rad5), 2);
        double rhs2 = 1 / pow(cos(rad5), 2);
        boolean id2 = abs(lhs2 - rhs2) < tol;

        double lhs3 = sin(2 * rad5);
        double rhs3 = 2 * sin(rad5) * cos(rad5);
        boolean id3 = abs(lhs3 - rhs3) < tol;

        System.out.println("\n=== Identity Verification Results ===");
        System.out.printf("sin²θ + cos²θ = 1 : %s%n", id1);
        System.out.printf("1 + tan²θ = sec²θ : %s%n", id2);
        System.out.printf("sin(2θ) = 2sinθcosθ : %s%n", id3);

        /// PROBLEM 5 ///
        System.out.print("Enter amplitude: ");
        double A2 = input.nextDouble();
        System.out.print("Enter frequency (Hz): ");
        double f = input.nextDouble();
        System.out.print("Enter phase shift (degrees): ");
        double phase = toRadians(input.nextDouble());
        System.out.print("Enter time (seconds): ");
        double t = input.nextDouble();

        double value = A2 * sin(2 * PI * f * t + phase);

        System.out.println("\n=== Wave Analysis ===");
        System.out.printf("Wave value at t = %.3f s: %.6f%n", t, value);

        double tol4 = 1e-6;
        if (abs(value - A2) < tol4) {
            System.out.println("Wave is at a PEAK.");
        } else if (abs(value + A2) < tol4) {
            System.out.println("Wave is at a TROUGH.");
        } else if (abs(value) < tol4) {
            System.out.println("Wave is at a ZERO-CROSSING.");
        } else {
            System.out.println("Wave is at a general point.");
        }

        double arg = 2 * PI * f * t + phase;
        double n = ceil((arg - PI / 2) / (2 * PI));
        double nextPeak = ((PI / 2) + 2 * PI * n - phase) / (2 * PI * f);
        System.out.printf("Next peak will occur at t = %.6f s%n", nextPeak);
    }
}
