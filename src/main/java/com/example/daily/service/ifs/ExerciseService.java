package com.example.daily.service.ifs;

import com.example.daily.vo.*;
import org.springframework.stereotype.Service;

@Service
public interface ExerciseService {
	
	public BasicRes fillInExercise(ExerciseReq req);
	
	public BasicRes updateExercise(UpdateExerciseReq req);

	public BasicRes deleteExercise(DeleteExerciseReq req);
	
	public GetExerciseRes getByEmail(GetExerciseReq req);

	public GetExerciseRes getCalendarExercise(GetExerciseReq req);
}
