package org.firstinspires.ftc.teamcode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo", group = "Tests")
public class servoTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Servo servo = hardwareMap.get(Servo.class, "servo");

        double setPosition = 0;
        double increment = 0.01;
        boolean pressed = false;
        boolean showControls = false;

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            if (!showControls) telemetry.addLine("Press Y to view controls.\n");
            else {
                telemetry.addLine("Press Y to hide controls.\n");
                telemetry.addLine("Controls:");
                telemetry.addLine("Left Trigger - Go to position");
                telemetry.addLine("Left Bumper - Turn on moving based on right trigger");
                telemetry.addLine("X - Set position to 0");
                telemetry.addLine("A - Set position to 0.5");
                telemetry.addLine("B - Set position to 1");
                telemetry.addLine("dpad down - Position down");
                telemetry.addLine("dpad up - Position up");
                telemetry.addLine("dpad left - Increment down");
                telemetry.addLine("dpad right - Increment up\n");
            }

            if (!pressed) {
                if (gamepad1.dpad_up) {
                    setPosition += increment;
                } else if (gamepad1.dpad_down) {
                    setPosition -= increment;
                } else if (gamepad1.dpad_left) {
                    increment -= 0.01;
                } else if (gamepad1.dpad_right) {
                    increment += 0.01;
                } else if (gamepad1.x) {
                    setPosition = 0;
                } else if (gamepad1.a) {
                    setPosition = 0.5;
                } else if (gamepad1.b) {
                    setPosition = 1;
                } else if (gamepad1.y) {
                    showControls = !showControls;
                }
            }

            pressed = gamepad1.dpad_up || gamepad1.dpad_down ||
                      gamepad1.dpad_left || gamepad1.dpad_right ||
                      gamepad1.y || gamepad1.x || gamepad1.a || gamepad1.b;

            if (gamepad1.left_trigger > 0) {
                servo.setPosition(setPosition);
            } else if (gamepad1.left_bumper) {
                servo.setPosition(gamepad1.right_trigger);
            }

            telemetry.addLine("Values:");
            telemetry.addData("Position", setPosition);
            telemetry.addData("Increment", increment);

            telemetry.update();
        }
    }
}
