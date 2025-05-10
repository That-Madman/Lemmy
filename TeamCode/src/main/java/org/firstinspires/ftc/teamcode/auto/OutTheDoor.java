package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous
public class OutTheDoor extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drive drive = new Drive(hardwareMap);

        Path thePath = drive.PathBuilder(new Vector2D(0, 0))
                .translationalScale(0.5)
                .point(new Vector2D(2.5, 146))
                .point(new Vector2D(71, 160.7))
                .point(new Vector2D(103, 197.5))
                .point(new Vector2D(76, 244.8))
                .point(new Vector2D(-1.5, 341.2))
                .point (new Vector2D(5, 500))
                .point(new Vector2D(2, 1241))
                .build();

        waitForStart();

        thePath.run();
    }
}
