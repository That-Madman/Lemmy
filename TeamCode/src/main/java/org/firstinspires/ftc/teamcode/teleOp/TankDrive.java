package org.firstinspires.ftc.teamcode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;

public class TankDrive extends LinearOpMode {
    Drive drive;

    @Override
    public void runOpMode () throws InterruptedException {
        drive = new Drive (hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            drive.tankDrive(gamepad1);
        }
    }
}
