package org.firstinspires.ftc.teamcode.trailblazer.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

@TeleOp
public class MotorTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            drive.runMotors(
                    new double[] {
                            (gamepad1.x) ? 0.4 : 0,
                            (gamepad1.y) ? 0.4 : 0,
                            (gamepad1.a) ? 0.4 : 0,
                            (gamepad1.b) ? 0.4 : 0
                    }
            );
        }
    }
}
