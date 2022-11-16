package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static java.lang.Thread.sleep;

@TeleOp(name = "TeleOp", group = "11846")
public class TeleOpB extends OpMode{

    Robot robot = new Robot();

    double drive = 0.00;

    double turn = 0.00;

    double eleDrive = 0.00;
    double rotateDrive = 0.00;

    @Override
    public void init(){robot.InitHardware(hardwareMap);}
    @Override
    public void loop(){
        drive = -gamepad1.left_stick_y;

        turn = -gamepad1.right_stick_x;

        eleDrive = -gamepad2.left_stick_y;
        rotateDrive = -gamepad2.right_stick_x;

        robot.FullDrive(drive, turn);

//        if(gamepad2.a){
//            robot.EleMotorTicks(0);
//        }else if(gamepad2.x){
//            robot.EleMotorTicks(1);
//        }else if(gamepad2.b){
//            robot.EleMotorTicks(2);
//        }else if(gamepad2.y){
//            robot.EleMotorTicks(3);
//        }else{
//            if (robot.robotHardware.eleMotor.isBusy()){
//
//            }else{
                robot.EleMotorStickWithLimits(gamepad2.left_stick_y);
//            }
//        }

        if(gamepad2.dpad_left){
            robot.RotateMotorTicks(0);
        }else if(gamepad2.dpad_up){
            robot.RotateMotorTicks(1);
        }else if(gamepad2.dpad_right){
            robot.RotateMotorTicks(2);
        }else{
            //while (robot.robotHardware.rotateMotor.isBusy()){

            //}
            robot.RotateMotorStickWithLimits(rotateDrive);
        }

        if(gamepad2.left_bumper){
            robot.GrabServoOpen();
        }
        if(gamepad2.right_bumper){
            robot.GrabServoClose();
        }
//        if(gamepad2.left_bumper){
//            robot.EleMotorDown10();
//        }
//        if(gamepad2.right_bumper){
//            robot.EleMotorUp10();
//        }

        telemetry.addData("Color", robot.ReturnColor());
        telemetry.addData("EleTicks",robot.GetElePos());
        telemetry.addData("GrabPos", robot.GetGrabPos());
        telemetry.addData("LeftTrigger", gamepad2.left_trigger);
        telemetry.addData("RightTrigger", gamepad2.right_trigger);
        telemetry.addData("RotatePos", robot.GetRotatePos());
        telemetry.addData("RightMotorTicks", robot.GetRightMotor());
        telemetry.addData("LeftMotorTicks", robot.GetLeftMotor());
        telemetry.addData("Heading", robot.robotHardware.imu.getAngularOrientation().firstAngle);
        telemetry.update();
    }
}
