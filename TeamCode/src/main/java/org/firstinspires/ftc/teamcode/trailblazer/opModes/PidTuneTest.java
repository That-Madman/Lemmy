package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.fotmrobotics.trailblazer.Pose2D;

@TeleOp
public class PidTuneTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            if (gamepad1.a) {
                drive.movePoint(new Pose2D(0, 0, 0));
                telemetry.addData("Error", drive.target.minus(drive.odometry.getPosition()).norm());
            } else {
                drive.mecanumDrive(gamepad1);
            }

            telemetry.update();
        }
    }
}
