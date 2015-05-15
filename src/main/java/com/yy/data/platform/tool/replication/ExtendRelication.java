package com.yy.data.platform.tool.replication;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.yy.data.platform.tool.replication.bean.DBOperate;
import com.yy.data.platform.tool.replication.bean.ShardGroup;
import com.yy.data.platform.tool.replication.bean.ShardRoute;
import com.yy.data.platform.tool.replication.exception.ReplicationException;
import com.yy.data.platform.util.RandomUtil;

public class ExtendRelication extends BaseRelication implements Replication{
	
	public ShardRoute findWriteRoute(String business, long bussinessId)
			throws Exception {
		ShardGroup targetGroup = findShardGroup(business, bussinessId);
		// 取模
		long mod = bussinessId % targetGroup.getHashMod();
		List<ShardRoute> shards = findShard(targetGroup, mod,DBOperate.w);
		if (!CollectionUtils.isEmpty(shards)) {
			return shards.get(RandomUtil.random(shards.size()));
		} else {
			throw new ReplicationException(
					"can not find shard ,shard is not exist!");
		}
	}
	
	private ShardGroup findShardGroup(String business, long bussinessId) throws Exception{
		List<ShardGroup> groups = getShardGroups(business);
		ShardGroup targetGroup = chooseTargetGroup(groups, bussinessId);
		return targetGroup;
	}

	public ShardRoute findReadRoute(String business, long bussinessId)
			throws Exception {
		ShardGroup targetGroup = findShardGroup(business, bussinessId);
		// 取模
		long mod = bussinessId % targetGroup.getHashMod();
		List<ShardRoute> shards = findShard(targetGroup, mod,DBOperate.r);
		if (!CollectionUtils.isEmpty(shards)) {
			return shards.get(RandomUtil.random(shards.size()));
		} else {
			throw new ReplicationException(
					"can not find shard ,shard is not exist!");
		}
	}

}
