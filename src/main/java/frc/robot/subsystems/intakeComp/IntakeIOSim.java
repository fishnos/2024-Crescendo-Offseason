package frc.robot.subsystems.intakeComp;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.indexer.Indexer;

public class IntakeIOSim extends SubsystemBase implements IntakeIO {

    double desiredVelocityRadSec = 0;

    private final Indexer indexer;
    public IntakeIOSim(Indexer i) {
        indexer = i;
    }
    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.velocityRadSec = desiredVelocityRadSec;
        inputs.inIntake = indexer.inIntake();
        inputs.reachedSetpoint = true;
        inputs.velocityMps = inputs.velocityRadSec * Math.PI * 2 * Constants.IntakeConstants.kROLLER_RADIUS_METERS;
        inputs.distanceMeters += inputs.velocityMps * 0.020;
    }

    @Override
    // sould be called periodically
    public void setVelocityRadSec(double goalVelocityRadPerSec) {
        desiredVelocityRadSec = goalVelocityRadPerSec;
    } 

    @Override
    public void setVoltage(double voltage){
    }

    @Override
    public void configureController(SimpleMotorFeedforward vff, PIDController vfb ) {
    }

}