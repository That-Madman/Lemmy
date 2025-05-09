package org.firstinspires.ftc.teamcode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp
public class Showtime extends LinearOpMode {
    boolean trueNorth, bHeld;
    Drive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            if (trueNorth)
                drive.trueNorthDrive(gamepad1);
            else
                drive.mecanumDrive(gamepad1);

            if (gamepad1.b && !bHeld)
                trueNorth ^= true;

            bHeld = gamepad1.b;

            telemetry.addData("Drivemode is", (trueNorth) ? "True North" : "Robot Relative");
            telemetry.update();
        }
    }
}
