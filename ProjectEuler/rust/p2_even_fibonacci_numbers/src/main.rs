fn main() {
    const MAX_NUMBER: i32 = 4_000_000;

    let sum = get_even_fibonacci_sum(MAX_NUMBER);

    println!("Sum: {}", sum);
}

fn get_even_fibonacci_sum(max_number: i32) -> i32 {
    let mut sum = 0;

    let mut prev_num = 1;
    let mut before_last_num = 1;
    loop {
        let cur_num = prev_num + before_last_num;
        if cur_num > max_number {
            break;
        }

        if is_even(cur_num) {
            sum = sum + cur_num;
        }

        before_last_num = prev_num;
        prev_num = cur_num;
    }

    return sum
}

fn is_even(num: i32) -> bool {
    return num % 2 == 0;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn sum_of_4_m_is_4613732() {
        assert_eq!(get_even_fibonacci_sum(4_000_000), 4613732);
    }
}