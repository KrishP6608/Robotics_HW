
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.move_turn;
import frc.robot.subsystems.ArcadeDrive;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Elevator;
import frc.robot.commands.raise_lower;
import edu.wpi.first.wpilibj2.commnad.button.Trigger;
import frc.robot.subsystems.Gyro;
import frc.robot.commands.raiseElevator;

public class RobotContainer {
  Subsystem arcadeDrive = new ArcadeDrive();
  Subsystem elevator = new Elevator();
  Subsystem gyro = new Gyro();
  public Joysitck joystick = new Joysitck(0);

  arcadeDrive.move(joystick.getY(), joystick.getX());

  public RobotContainer(){
    configureButtonBindings();
    
    arcadeDrive.setDefaultCommand(()-> new RunCommand(move_turn(arcadeDrive)));
    elevator.setDefaultCommand(() -> new RunCommand(raise_lower()));
    gyro.setDefaultCommand(() -> new RunCommand(checkAngle()));
  }
  private void configureButtonBindings(){
    new Trigger(() -> joystick.getRawButton(2).onTrue(new InstantCommand(raise_lower())));

  }

  public Command getAutonomousCommand(){
    return new moveTurn();
  }
}
