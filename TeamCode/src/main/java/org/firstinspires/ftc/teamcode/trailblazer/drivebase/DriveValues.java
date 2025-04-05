package org.firstinspires.ftc.teamcode.trailblazer.drivebase;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.fotmrobotics.trailblazer.PIDF;
import org.fotmrobotics.trailblazer.Pose2D;

/**
 * Edit all components here.
 */
@Config
public class DriveValues {
    // TODO: Change if necessary.
    /*
    Name of the motors in the configuration

    0. Front Left
    1. Front Right
    2. Back Left
    3. Back Right
    */
    final String[] motorNames = {
            "fl",
            "fr",
            "bl",
            "br"
    };

    // TODO: Reverse motors if necessary.
    public static int[] reverseMotors = {1, 2, 3};

    public static double posP = 0.1,
            posI = 0,
            posD = 0,
            posF = 0;
    // TODO: Tune the PIDF loops.
    final PIDF positionPID = new PIDF(posP, posI, posD, posF);

    public static double headP = 0.01,
            headI = 0,
            headD = 0,
            headF = 0;
    final PIDF headingPID = new PIDF(headP, headI, headD, headF);

    // TODO: Change if necessary.
    // Name of the SparkFunOTOS in the configuration.
    final String SparkFunOTOS = "otos";

    // TODO: Change if necessary.
    // Position of the SparkFunOTOS relative to the center.
    public static Pose2D offset = new Pose2D(0.125,3, 0);

    // Units
    public static DistanceUnit linearUnit = DistanceUnit.INCH;
    public static AngleUnit angularUnit = AngleUnit.DEGREES;

    // TODO: Tune the linear and angular scalar.

    // Sets the linear scale for the SparkFunOTOS.
    public static double linearScalar = 1.1554849426;

    // Sets the angular scale for the SparkFunOTOS.
    public static double angularScalar = 1;

    // Scale for speed.
    public static double xScale = 1;
    public static double yScale = 1;
    public static double angularScale = 1;
}