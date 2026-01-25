package week1.programmers.lv3;


import java.util.*;

public class P42627 {

    static class Job{
        int requestTime;
        int duration;

        public Job(int requestTime, int duration){
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }

    public int solution(int[][] jobs) {
        // 대기열로의 삽입 관리를 위한 리스트
        List<Job> job_list = new ArrayList<>();

        for(int[] job : jobs){
            job_list.add(new Job(job[0],job[1]));
        }

        job_list.sort((a,b)->Integer.compare(a.requestTime,b.requestTime));

        // 대기열 내 작업 처리를 위한 우선순위 큐
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)->Integer.compare(a.duration,b.duration));

        int finished_job = 0;
        int cur_job_list_idx=0;
        int cur_time = 0;
        int total =0;

        while(finished_job < job_list.size()){
            while(cur_job_list_idx < job_list.size()
                    && job_list.get(cur_job_list_idx).requestTime <= cur_time){
                pq.add(job_list.get(cur_job_list_idx++));
            }

            if(pq.isEmpty()) cur_time=job_list.get(cur_job_list_idx).requestTime;
            else{
                Job cur_job = pq.poll();
                cur_time += cur_job.duration;
                total += cur_time - cur_job.requestTime;
                finished_job++;
            }
        }





        return total / job_list.size();

    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42627 s = new P42627();

        // 테스트 케이스 1
        int[][] jobs1 = {{0, 3}, {1, 9}, {3, 5}};
        System.out.println("Result 1: " + s.solution(jobs1)); // Expected: 8

        // 테스트 케이스 2
        int[][] jobs2 = {{0, 10}, {4, 10}, {5, 11}, {15, 2}};
        System.out.println("Result 2: " + s.solution(jobs2));
    }
}