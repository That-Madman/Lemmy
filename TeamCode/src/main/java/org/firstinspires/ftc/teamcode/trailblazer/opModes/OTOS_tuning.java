package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Odometry;
import org.fotmrobotics.trailblazer.Pose2D;

@TeleOp
public class OTOS_tuning extends LinearOpMode {

    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap);

        waitForStart();

        if (isStopRequested()) {return;}

        while (opModeIsActive()) {
            drive.mecanumDrive(gamepad1);

            Pose2D pos = drive.odometry.getPosition();

            telemetry.addData("X", pos.getX());
            telemetry.addData("Y", pos.getY());
            telemetry.addData("H", pos.getH());
            telemetry.update();
        }
    }
}
