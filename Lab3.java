/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab3;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author Ivy R. Bangelisan
 */
public class Lab3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /// PROBLEM 1 – Trigonometric Functions ///
        System.out.println("=== PROBLEM 1: Trigonometric Functions ===");
        System.out.print("Enter angle in degrees: ");
        double angleDeg1 = input.nextDouble();
        double rad1 = toRadians(angleDeg1);

        System.out.println("Choose function:");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. All three");
        int choice1 = input.nextInt();

        switch (choice1) {
            case 1:
                System.out.println("sin(" + angleDeg1 + "°) = " + sin(rad1));
                break;
            case 2:
                System.out.println("cos(" + angleDeg1 + "°) = " + cos(rad1));
                break;
            case 3:
                if (abs(cos(rad1)) < 1e-10) {
                    System.out.println("tan(" + angleDeg1 + "°) is undefined!");
                } else {
                    System.out.println("tan(" + angleDeg1 + "°) = " + tan(rad1));
                }
                break;
            case 4:
                System.out.println("sin(" + angleDeg1 + "°) = " + sin(rad1));
                System.out.println("cos(" + angleDeg1 + "°) = " + cos(rad1));
                if (abs(cos(rad1)) < 1e-10) {
                    System.out.println("tan(" + angleDeg1 + "°) is undefined!");
                } else {
                    System.out.println("tan(" + angleDeg1 + "°) = " + tan(rad1));
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        /// PROBLEM 2 – Quadrant Detection ///
        System.out.println("\n=== PROBLEM 2: Quadrant Detection ===");
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();
        angle = ((angle % 360) + 360) % 360;
        System.out.println("Normalized angle: " + angle + "°");

        int quadCase;
        if (angle == 0 || angle == 180 || angle == 360) quadCase = 0;
        else if (angle == 90 || angle == 270) quadCase = -1;
        else if (angle > 0 && angle < 90) quadCase = 1;
        else if (angle > 90 && angle < 180) quadCase = 2;
        else if (angle > 180 && angle < 270) quadCase = 3;
        else quadCase = 4;

        switch (quadCase) {
            case 0:
                System.out.println("On X-axis: sine = 0, cosine = ±1, tangent = 0");
                break;
            case -1:
                System.out.println("On Y-axis: sine = ±1, cosine = 0, tangent = undefined");
                break;
            case 1:
                System.out.println("Quadrant I: sin +, cos +, tan +");
                break;
            case 2:
                System.out.println("Quadrant II: sin +, cos -, tan -");
                break;
            case 3:
                System.out.println("Quadrant III: sin -, cos -, tan +");
                break;
            case 4:
                System.out.println("Quadrant IV: sin -, cos +, tan -");
                break;
        }

        /// PROBLEM 3 – Right Triangle Solver ///
        System.out.println("\n=== PROBLEM 3: Right Triangle Solver ===");
        System.out.println("Choose what you know:");
        System.out.println("1. Two sides");
        System.out.println("2. One side and one angle (< 90°)");
        int choice2 = input.nextInt();

        double a = 0, b = 0, c = 0;
        double A = 0, B = 0, C = 90;

        switch (choice2) {
            case 1:
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
                break;

            case 2:
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
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\n=== Results ===");
        System.out.printf("Sides: a = %.2f, b = %.2f, c = %.2f%n", a, b, c);
        System.out.printf("Angles: A = %.2f°, B = %.2f°, C = 90°%n", A, B);
        System.out.printf("Area = %.2f%n", 0.5 * a * b);

        /// PROBLEM 4 – Identity Verification ///
        System.out.println("\n=== PROBLEM 4: Trigonometric Identities ===");
        System.out.print("Enter angle in degrees: ");
        double angleDeg4 = input.nextDouble();
        double rad4 = toRadians(angleDeg4);
        double tol = 1e-6;

        System.out.println("Choose identity to verify:");
        System.out.println("1. sin²θ + cos²θ = 1");
        System.out.println("2. 1 + tan²θ = sec²θ");
        System.out.println("3. sin(2θ) = 2sinθcosθ");
        System.out.println("4. All three");
        int choice3 = input.nextInt();

        switch (choice3) {
            case 1:
                System.out.println("sin²θ + cos²θ = 1 : " +
                        (abs(pow(sin(rad4), 2) + pow(cos(rad4), 2) - 1) < tol));
                break;
            case 2:
                System.out.println("1 + tan²θ = sec²θ : " +
                        (abs(1 + pow(tan(rad4), 2) - (1 / pow(cos(rad4), 2))) < tol));
                break;
            case 3:
                System.out.println("sin(2θ) = 2sinθcosθ : " +
                        (abs(sin(2 * rad4) - (2 * sin(rad4) * cos(rad4))) < tol));
                break;
            case 4:
                System.out.println("sin²θ + cos²θ = 1 : " +
                        (abs(pow(sin(rad4), 2) + pow(cos(rad4), 2) - 1) < tol));
                System.out.println("1 + tan²θ = sec²θ : " +
                        (abs(1 + pow(tan(rad4), 2) - (1 / pow(cos(rad4), 2))) < tol));
                System.out.println("sin(2θ) = 2sinθcosθ : " +
                        (abs(sin(2 * rad4) - (2 * sin(rad4) * cos(rad4))) < tol));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        /// PROBLEM 5 – Wave Analysis ///
        System.out.println("\n=== PROBLEM 5: Wave Analysis ===");
        System.out.print("Enter amplitude: ");
        double A2 = input.nextDouble();
        System.out.print("Enter frequency (Hz): ");
        double f = input.nextDouble();
        System.out.print("Enter phase shift (degrees): ");
        double phase = toRadians(input.nextDouble());
        System.out.print("Enter time (seconds): ");
        double t = input.nextDouble();

        double value = A2 * sin(2 * PI * f * t + phase);
        double arg = 2 * PI * f * t + phase;
        double tol5 = 1e-6;

        System.out.println("Choose analysis option:");
        System.out.println("1. Show wave value at time t");
        System.out.println("2. Classify (Peak, Trough, Zero, General)");
        System.out.println("3. Find next peak");
        System.out.println("4. Find next trough");
        System.out.println("5. Find next zero-crossing");
        int choice4 = input.nextInt();

        switch (choice4) {
            case 1:
                System.out.printf("Wave value at t = %.3f s: %.6f%n", t, value);
                break;
            case 2:
                if (abs(value - A2) < tol5) {
                    System.out.println("Wave is at a PEAK.");
                } else if (abs(value + A2) < tol5) {
                    System.out.println("Wave is at a TROUGH.");
                } else if (abs(value) < tol5) {
                    System.out.println("Wave is at a ZERO-CROSSING.");
                } else {
                    System.out.println("Wave is at a general point.");
                }
                break;
            case 3:
                double nPeak = ceil((arg - PI / 2) / (2 * PI));
                double nextPeak = ((PI / 2) + 2 * PI * nPeak - phase) / (2 * PI * f);
                System.out.printf("Next peak at t = %.6f s%n", nextPeak);
                break;
            case 4:
                double nTrough = ceil((arg - (3 * PI / 2)) / (2 * PI));
                double nextTrough = ((3 * PI / 2) + 2 * PI * nTrough - phase) / (2 * PI * f);
                System.out.printf("Next trough at t = %.6f s%n", nextTrough);
                break;
            case 5:
                double nZero = ceil((arg - 0) / (PI));
                double nextZero = ((PI * nZero) - phase) / (2 * PI * f);
                System.out.printf("Next zero-crossing at t = %.6f s%n", nextZero);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}