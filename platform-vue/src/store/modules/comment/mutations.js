export default {
  setCommentCount(state, data){
    let nums = data.map(n=>n.num)
    state.totals = {
      nums,
      labels:['全部','好评','中评','差评','有图'],
      favorableRating: (nums[1]/nums[0] * 100).toFixed(1),
      totalStars: Math.round(nums[1]/nums[0] * 5)
    }
  }
}
